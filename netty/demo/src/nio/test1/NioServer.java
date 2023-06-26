package nio.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/*未能发消息给客户端*/

/**
 * @BelongsProject: netty
 * @BelongsPackage: nio.test1
 * @FileName: NioServer
 * @Author: wude
 * @Date: 2023/6/25-21:51
 * @Version: 1.0
 * @Description:
 */
public class NioServer {

    private Selector selector;

    public void initServer(int port) throws IOException {
        // 创建一个ServerSocketChannel对象并设置为非阻塞模式
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);

        // 绑定端口号并注册到Selector中
        serverChannel.socket().bind(new InetSocketAddress(port));
        //这里为什么要先.socket()才bind()
        this.selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器已启动，监听端口：" + port);
    }

    public void listen() throws IOException {
        while (true) {
            // 阻塞等待就绪的Channel
            int readyChannels = selector.select();

            if (readyChannels == 0) {
                continue;
            }

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            //Selector的selectedKeys() 获取已连接的所有通道的集合
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();
                //为什么要remove，
                // 难道是因为while (true)能让它延续这个while (keyIterator.hasNext())
                //所以他才一次只获取一个（keyIterator的第一个）
                //remove有什么用

                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    private void accept(SelectionKey key) throws IOException {
        // 接收新连接
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverChannel.accept();
        //selector的精妙之处就在这里，可以控制他的accept方法的位置
        socketChannel.configureBlocking(false);

        // 注册到Selector中，监听读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        //socketChannel是服务端accept到的客户端，这里是监听不同事件了（读）
        System.out.println("客户端[" + socketChannel.getRemoteAddress() + "]已连接");
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        //这里的key.channel()的类型为什么和设定的accept（）方法不一样，
        // 难道说这个key就是监听已连接的所有通道集合，可以切换使用两方的通道

        // 读取客户端发送的数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int readBytes = socketChannel.read(buffer);
        //这里应该是长度
        if (readBytes > 0) {
            buffer.flip();
            byte[] data = new byte[buffer.remaining()];
            //buffer.remaining()方法有什么作用，难道是命名等长的byte数组
            buffer.get(data);
            //如果上面猜测正确，这里难道是将buffer存入data中，所以下面就没用到buffer了
            String message = new String(data).trim();
            System.out.println("收到客户端[" + socketChannel.getRemoteAddress() + "]的消息：" + message);

            // 回复客户端
            String replyMessage = "你好，我已收到你发来的消息：【" + message + "】";
            ByteBuffer replyBuffer = ByteBuffer.wrap(replyMessage.getBytes());
            //wrap应该是复制作用
            socketChannel.write(replyBuffer);
        } else {
            // 客户端关闭通道
            System.out.println("客户端[" + socketChannel.getRemoteAddress() + "]断开连接");
            key.cancel();
            //cancel是什么作用，猜测释放
            socketChannel.close();
        }
    }

    public static void main(String[] args) throws IOException {
        NioServer server = new NioServer();
        server.initServer(9999);
        server.listen();
    }

/*    该程序中，我们首先创建了一个ServerSocketChannel对象并设置为非阻塞模式，然后将其绑定到指定的端口，并注册到Selector中以监听连接请求。

    在不断的循环中，我们使用Selector.select()方法进行阻塞等待就绪的Channel，当有就绪的Channel时，使用Selector.selectedKeys()获取所有就绪的SelectionKey，并遍历处理每个SelectionKey。

    如果该SelectionKey表示一个新的连接请求，则调用accept()方法接收新的连接，并将其注册到Selector中以监听读事件。

    如果该SelectionKey表示一个读事件，则调用read()方法读取客户端发送的数据，并回复客户端。如果客户端已关闭通道，则取消该SelectionKey并关闭SocketChannel。

    在read()方法中，我们使用ByteBuffer来读写数据，这是NIO中常用的操作方式。同时，我们也可以看到，在程序中使用了Buffer、Channel和Selector等NIO相关的知识进行优化，使得程序运行更加高效和稳定。*/
}

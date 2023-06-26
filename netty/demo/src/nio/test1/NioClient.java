package nio.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/*未能接收到服务器消息*/

/**
 * @BelongsProject: netty
 * @BelongsPackage: nio.test1
 * @FileName: NioClient
 * @Author: wude
 * @Date: 2023/6/25-22:30
 * @Version: 1.0
 * @Description:
 */
public class NioClient {

    public void start(String serverHost, int serverPort) throws IOException {
        // 创建SocketChannel对象并设置为非阻塞模式
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        // 连接到服务器
        boolean connected = socketChannel.connect(new InetSocketAddress(serverHost, serverPort));
        if (!connected) {
            // 如果连接还未完成，这里需要等待连接完成
            while (!socketChannel.finishConnect()) {
                System.out.println("正在连接服务器...");
            }
        }

        System.out.println("已连接到服务器[" + serverHost + ":" + serverPort + "]");

        // 发送数据
        String message = "Hello, Server!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        socketChannel.write(buffer);

        // 接收服务器返回的数据
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int readBytes = socketChannel.read(readBuffer);
        if (readBytes > 0) {
            readBuffer.flip();
            byte[] data = new byte[readBuffer.remaining()];
            readBuffer.get(data);
            String replyMessage = new String(data).trim();
            System.out.println("收到服务器的回复：" + replyMessage);
        }

        // 关闭连接
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        NioClient client = new NioClient();
        client.start("localhost", 9999);
    }
}

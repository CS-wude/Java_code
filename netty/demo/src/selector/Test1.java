package selector;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @BelongsProject: netty
 * @BelongsPackage: selector
 * @FileName: Test1
 * @Author: wude
 * @Date: 2023/6/24-17:09
 * @Version: 1.0
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel ssc1 = ServerSocketChannel.open();
        ssc1.bind(new InetSocketAddress(7777));

        ServerSocketChannel ssc2 = ServerSocketChannel.open();
        ssc2.bind(new InetSocketAddress(8888));

        ServerSocketChannel ssc3 = ServerSocketChannel.open();
        ssc3.bind(new InetSocketAddress(9999));

        ssc1.configureBlocking(false);
        ssc2.configureBlocking(false);
        ssc3.configureBlocking(false);

        Selector selector = Selector.open();

        ssc1.register(selector , SelectionKey.OP_ACCEPT);
        ssc2.register(selector , SelectionKey.OP_ACCEPT);
        ssc3.register(selector , SelectionKey.OP_ACCEPT);

        //死循环，一直接收客户端的连接请求
        while(true){
            System.out.println(1);
            selector.select(); //阻塞
            System.out.println(2);

            Set<SelectionKey> keySet = selector.selectedKeys();
            //所有被连接的channel对象

            for(SelectionKey key : keySet){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
            }
        }
    }
}

package channel.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @BelongsProject: netty
 * @BelongsPackage: channel.test1
 * @FileName: Server
 * @Author: wude
 * @Date: 2023/6/24-18:27
 * @Version: 1.0
 * @Description:
 */
public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocketChannel ssc = ServerSocketChannel.open();

        ssc.bind(new InetSocketAddress(8888));

        SocketChannel sc = ssc.accept();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int len = sc.read(buffer);

        System.out.println(new String(buffer.array() , 0 , len));

        sc.close();
    }
}

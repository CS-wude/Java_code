package channel.test1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @BelongsProject: netty
 * @BelongsPackage: channel.test1
 * @FileName: Client
 * @Author: wude
 * @Date: 2023/6/24-18:48
 * @Version: 1.0
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws IOException{
        SocketChannel sc = SocketChannel.open();

        sc.connect(new InetSocketAddress("127.0.0.1" , 8888));

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put("你好啊~".getBytes());

        //将position值给limit ， position设为0,实现实际长度传输
        buffer.flip();

        sc.write(buffer);

        sc.close();
    }
}

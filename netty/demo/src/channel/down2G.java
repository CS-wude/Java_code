package channel;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @BelongsProject: netty
 * @BelongsPackage: channel
 * @FileName: down2G
 * @Author: wude
 * @Date: 2023/6/24-18:02
 * @Version: 1.0
 * @Description:
 */
public class down2G {
    public static void main(String[] args) throws Exception{
        RandomAccessFile r1 = new RandomAccessFile("D:\\wude\\java\\netty\\demo\\File\\a.txt" , "r");
        RandomAccessFile r2 = new RandomAccessFile("D:\\wude\\java\\netty\\demo\\File\\aCopy2.txt" , "rw");

        FileChannel c1 = r1.getChannel();
        FileChannel c2 = r2.getChannel();

        long size = c1.size();

        //把硬盘上的文件映射到内存中
        MappedByteBuffer b1 = c1.map(FileChannel.MapMode.READ_ONLY , 0 , size);
        MappedByteBuffer b2 = c2.map(FileChannel.MapMode.READ_WRITE , 0 ,size);

        for (long i = 0 ; i < size ; i++){
            byte b = b1.get();
            b2.put(b);
        }

        c2.close();
        c1.close();
        r2.close();
        r1.close();

    }
}

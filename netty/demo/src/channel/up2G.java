package channel;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @BelongsProject: netty
 * @BelongsPackage: channel
 * @FileName: up2G
 * @Author: wude
 * @Date: 2023/6/24-18:10
 * @Version: 1.0
 * @Description:
 */
public class up2G {
    public static void main(String[] args) throws Exception{
        RandomAccessFile r1 = new RandomAccessFile("D:\\wude\\java\\netty\\demo\\File\\a.txt" , "r");
        RandomAccessFile r2 = new RandomAccessFile("D:\\wude\\java\\netty\\demo\\File\\aCopy3.txt" , "rw");

        FileChannel c1 = r1.getChannel();
        FileChannel c2 = r2.getChannel();

        long size = c1.size();

        //每次期望500M
        int everySize = 1024*1024*500;

        //复制次数
        long count = size % everySize == 0 ? size/everySize : size/everySize + 1;

        for (long i = 0 ; i < count ; i++){
            //每次开始复制的位置
            long start = everySize * i;

            //每次复制的实际大小
            long trueSize = size - start > everySize ? everySize : size - start;

            // 直接把硬盘中的文件映射到内存中
            MappedByteBuffer b1 = c1.map(FileChannel.MapMode.READ_ONLY, start, trueSize);
            MappedByteBuffer b2 = c2.map(FileChannel.MapMode.READ_WRITE, start, trueSize);

            for (long j = 0 ; j < trueSize ; j++){
                byte b = b1.get();
                b2.put(b);
            }
        }

        c2.close();
        c1.close();
        r2.close();
        r1.close();
    }
}

package channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @BelongsProject: netty
 * @BelongsPackage: channel
 * @FileName: CopyFile
 * @Author: wude
 * @Date: 2023/6/24-17:51
 * @Version: 1.0
 * @Description:
 */
public class CopyFile {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("D:\\wude\\java\\netty\\demo\\File\\a.txt");
        FileOutputStream fos = new FileOutputStream("D:\\wude\\java\\netty\\demo\\File\\aCopy.txt");

        FileChannel c1 = fis.getChannel();
        FileChannel c2 = fos.getChannel();

        ByteBuffer b = ByteBuffer.allocate(1000);


        /*byte[] bys = new byte[8192];
int len;
while ((len = fis.read(bys)) != -1){
fos.write(bys,0,len);
}
fos.close();
fis.close();*/
        while((c1.read(b)) != -1){
            // 重置 postion为0,limit为postion的位置
            b.flip();
            c2.write(b);
            // positon为:0 limit为: capacity 用于下次读取
            b.clear();
        }

        c2.close();
        c1.close();
        fos.close();
        fis.close();
    }
}

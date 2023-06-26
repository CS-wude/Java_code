package buffer;

import java.nio.ByteBuffer;

/**
 * @BelongsProject: netty
 * @BelongsPackage: buffer
 * @FileName: ByteBufferMake
 * @Author: wude
 * @Date: 2023/6/24-11:46
 * @Version: 1.0
 * @Description:
 */
public class ByteBufferMake {
    public static void mian(String[] args){
        //在堆中创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        //系统内存创建缓冲区
        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(10);

        //通过数组创建缓冲区
        byte[] byteArray = new byte[10];
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArray);

    }

}

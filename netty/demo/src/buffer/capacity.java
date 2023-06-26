package buffer;

import java.nio.ByteBuffer;

/**
 * @BelongsProject: netty
 * @BelongsPackage: buffer
 * @FileName: capacity
 * @Author: wude
 * @Date: 2023/6/24-16:13
 * @Version: 1.0
 * @Description:
 */
public class capacity {
    public static void main(String[] args) {
        ByteBuffer b1 = ByteBuffer.allocate(10);
        System.out.println("容量不可变"  + b1.capacity());

        byte[] byteArray = {97 , 98 , 99 , 100};
        ByteBuffer b2 = ByteBuffer.wrap(byteArray);
        System.out.println("容量不可变" + b2.capacity());
    }
}

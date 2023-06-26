package buffer;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @BelongsProject: netty
 * @BelongsPackage: buffer
 * @FileName: put
 * @Author: wude
 * @Date: 2023/6/24-15:58
 * @Version: 1.0
 * @Description:
 */
public class put {
    public static void main(String[] args) {
        ByteBuffer b1 = ByteBuffer.allocate(10);

        //添加数据
        b1.put((byte)11);
        b1.put((byte)12);
        b1.put((byte)13);

        //ByteBuffer转化为普通字节数组
        byte[] bytes = b1.array();
        System.out.println(Arrays.toString(bytes));

        byte[] b2 = {14 , 15 , 16};

        b1.put(b2 , 0 , 1);

        byte[] b = b1.array();
        System.out.println(Arrays.toString(b));
    }
}

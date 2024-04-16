package one_month;
import java.util.Scanner;
import java.math.BigInteger;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class day2_FindYuNum_BigInteger {

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
			/*
			 * 不是很明白10的作用
			 * 解答：应该是进制
			 * BigInteger a = new
			 * BigInteger("12345678901234567890123456789012345678901234567890",10);
			 * BigInteger b = new BigInteger("2023",10);
			 */
	        BigInteger a = new BigInteger("12345678901234567890123456789012345678901234567890");
	        BigInteger b = new BigInteger("2023");
	        System.out.println(a.mod(b));
	        scan.close();
	    }
	
}

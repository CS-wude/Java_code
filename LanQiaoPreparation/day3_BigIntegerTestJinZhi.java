package one_month;

import java. math.BigInteger;

/*
 * 进制位很有用
 * */
public class day3_BigIntegerTestJinZhi {
	public static void main(String[] args) {
		BigInteger a = new BigInteger("16",16);
		//输出22,16+6，可输出十进制数值
		System.out.println(a);
		BigInteger b = new BigInteger("16",8);
		BigInteger c = new BigInteger("16",10);
		System.out.println(b + "," + c);
		
	}
}

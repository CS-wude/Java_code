package one_month;

import java.lang.Long;

/*
 * 本以为long很万能，但依旧会越界
 * 是否是valueOf会先String转int再转long呢
 * valueOf很好用,可以字符串转其他类型，也可以其他类型转字符串
 * java.lang.Long要记住*/
public class day2_FindYuNum {
	public static void main(String[] args) {
		//好像不能直接用12345678901234567890123456789012345678901234567890,应该是越界
		long l = Long.valueOf("1234567890");
		l %= 2023;
		System.out.println(l);
		
		 long t = 1234567890; 
		 
		 for(int i = 0; i < 4; i++) {
		 t %=2023;
		 t *= Long.valueOf("10000000000");
		 t += Long.valueOf("1234567890");
		 }
		 t %=2023;
		 System.out.println(t);
		 
	}
}

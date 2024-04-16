package one_month;

import java.util.Scanner;
import java.math.BigInteger;
/*试上*/
public class day10_MakeNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		String[] strr = str.split(" ");
		//我其实也想到用链表，每个地址存一位，从size（）-1一直减9
		BigInteger N = new BigInteger(strr[0]);
		//BigInteger M = new BigInteger(str2);
		int m = Integer.parseInt(strr[1]);
		
		String str3 = "";
		while(!N.equals(new BigInteger("0"))) {
			//while(!N.equals(0)) {
			//这里发生了无限循环,如果向上面那样就会一直减到负数都不停
			
			str3 += "9";
			N = N.subtract(new BigInteger("1"));
			
			
		}
		
		System.out.println(str3);
		
			int n = str3.length();
			n *= 9;
			System.out.println(n);
			n -= m;
			System.out.println(n);
			N = new BigInteger(str3);
			m = n/9;
			System.out.println(m);
			String strm = "";
			while(m != 0) {
				strm += "0";
				m--;
			}
			
			//这里如果str3只有一个，比如一个9，m是0，那就是输入了1，从1而不是从0 开始他居然输出9
			//str3.substring(m+1)
			//我知道了，我没有把他输出来
			str3 = str3.substring(m+1);
			//
			n = n%9;
			str3 += n;
			str3 += strm;
			System.out.println(str3);
			scan.close();
			
			
			
		
	}
}

package one_month;

import java.util.Scanner;

public class day17_FeiContror {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] num = new long[n];
		for(int i = 0; i < n; i++) {
			num[i] = scan.nextInt();
		}
		long min = Long.valueOf("1000000000000");
		for(int i = 1; i < n; i++) {
			num[i] = Mgbs(num[i-1], num[i], Mgys(num[i-1], num[i]));
			if(Math.min(min, num[i]) > 0) {
				min = Math.min(min, num[i]);
			}
			
		}
		System.out.println(min);
		scan.close();
	}
	public static long Mgys(long m, long n) {
		long a,b;
		if(m > n) {
			a = m;
			b = n;
		}else if(m < n) {
			a = n;
			b = m;
		} else {
			return m;
		}
		while(true) {
			if(a % b == 0) return b;
			long tmp = b;
			b = a%b;
			a = tmp;
		}
	}
	public static long Mgbs(long m, long n, long gys) {
		long num = m*n;
		num /= gys;
		//System.out.println(num);
		return num;
	}
}

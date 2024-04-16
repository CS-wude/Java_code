package one_month;

import java.util.Scanner;

public class day16_UnfairCoin {
	static double ans = 0;
	static int t = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double a = scan.nextDouble();
		double b = scan.nextDouble();
		a /= b;
		//b = 1-a;
		K(n, a);
		System.out.println(ans);
		System.out.println(t);
		
		
		
		scan.close();
	}
	//未考虑到连续的1，比如011，那你就会经历11和10，那10应该就不好加到
	//而且不仅要用到a，还要用到1-a，当110，那就是a*a*(1-a)，我这里只算了a一次
	public static void K(int n, double a) {
		if(n == 0) return;
		for(int i = 0; i <= 1; i++) {
			if(i == 1) t++;
			ans += (i * a);
			ans %= 998244353;
			K(n-1, a);
		}
		return;
	}
}

package one_month;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day13j10_java9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] a = new long[n];
		for(int i = 0; i < n; i++) {
			a[i] = scan.nextLong();
		}
		List<Long> s = new ArrayList<>();
		for(int i = 0; i < n-1; i ++) {
			for(int j = i+1; j < n; j++) {
				//System.out.println(gbs(a[i],a[j]));
				s.add(gbs(a[i],a[j]));
			}
		}
		long ans = 0;
		for(int i = 0; i < s.size()-1; i++) {
			long ann = gys(s.get(i),s.get(i+1));
			ans = Math.max(ans, ann);
		}
		System.out.println(ans);
		scan.close();
	}
	public static long gbs(long a, long b) {
		long c = a * b;
		c /= gys(a, b);
		return c;
	}
	public static long gys(long a, long b) {
		long tmp = a;
		a = Math.max(a, b);
		b = Math.min(tmp, b);
		while(true) {
			tmp = b;
			a %= b;
			if( a == 0) {
				return b;
			}
			b = a;
			a = tmp;
		}
	}
}

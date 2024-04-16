package one_month;

import java.util.Arrays;
import java.util.Scanner;

public class day13j10_java10 {
	static boolean flag = false, aflag = false;
	static long ans = 0;
	static int j ;
	public static void main(String[] args) {
		/*
		 * String str = "1000000000000000000"; long s = Long.valueOf(str);
		 * System.out.println(s);
		 */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//String str = scan.nextLine();
		//String[] Str = str.split(" ");
		long[] a = new long[n];
		for(int i = 0 ;i < n;i++) {
			a[i] = scan.nextLong();
		}
		Arrays.sort(a);
		/*
		 * for(int i = 0; i < n-1; i++) { for(int j = i+1; i < n; i++) { long ann1 =
		 * xy(a[i], a[j]); if(flag == true) { flag = false; ann1 += 7; } long ann2 =
		 * xy(a[j], a[i]); if(flag == true) { flag = false; ann2 += 7; } ann1 =
		 * Math.max(ann1, ann2); ans = Math.max(ans, ann1); } }
		 */
		j = n-1;
		for(int i = n-2; i >=0; i--) {
				long ann1 = xy(a[j], a[i]);
				/*
				 * if(flag == true) { flag = false; ann1 %= 1000000000; ann1 += 7; }
				 */
				long ann2 = xy(a[i], a[j]);
				/*
				 * if(flag == true) { flag = false; ann2 %= 1000000000; ann2 += 7; }
				 */
				long k = Math.max(ann1, ann2);
				if(k == ann2) {
					j = i;
				}
				if(flag == true) {
					flag = false;
					k %= 1000000000;
					k += 7;
				}
				ans += k;
				if (ans >= 1000000000) {
					aflag = true;
					
			}
				
			
		}
		if(aflag == true) {
			ans %= 1000000000;
			ans += 7;
		}
		
		System.out.println(ans);
		
		scan.close();
	}
	public static long xy(long x, long y) {
		for(int i = 1; i < y; i++) {
			x *= x;
			
			if (x >= 1000000000) {
				flag = true;
				/* x %= 1000000000; */}
			 
		}
		return x;
	}
}

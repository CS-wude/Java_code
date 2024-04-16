package one_month;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day13j10_java8 {
	static int ans = 0, n , k;
	static boolean q;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
			if((a[i] + a[i]) <= k) ans++;
		}
		Arrays.sort(a);
		if(n > 1) {
			for(int i = 2; i <= n; i++) {
				dfs(i,0,new ArrayList(), a);
				
			}
			
		}
		if(q == true) ans += 7;
		System.out.println(ans);
		scan.close();
		
	}
	public static void dfs(int i ,int start,List<Integer> an, int[] a) {
		if( i == 0) {
			if((an.get(0) + an.get(an.size() - 1)) <= k) ans++;
			if(ans >= 1000000000) {
				q = true;
			}
			ans %= 1000000000;
			
			return;
		}
		for(int j = start; j < n; j++) {
			an.add(a[j]);
			dfs(i-1, start + 1, an, a);
			an.remove(an.size() - 1);
		}
	}
}

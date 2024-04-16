package one_month;

import java.util.Scanner;

public class day1_FloorGrade_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		//依旧是动态规划，但这回是依据这题的逻辑建立的
		//学会利用java的优势，long
		long dp[] = new long[n+1];
		/*
		 * 不是很明白为什么要设置dp[0]为1 dp[0] = 1;
		 */
		dp[a] = 1;
		dp[b] = 1;
		dp[c] = 1;
		
		for(int i = 1; i <= n ; i++) {
			//i等于a就没必要相加了
			if(i-a > 0) {
				dp[i] += dp[i - a];
				dp[i] %= 1000000007;
			}
			if(i-b > 0) {
				dp[i] += dp[i - b];
				dp[i] %= 1000000007;
			}
			if(i-c > 0) {
				dp[i] += dp[i - c];
				dp[i] %= 1000000007;
			}
		}
		System.out.println(dp[n]);
		
		scan.close();
	}
}

package one_month;

public class Hello_DP_01dp {
	public int dp(int[] wgt, int[] val, int cap) {
		int n = wgt.length;
		int[][] dp = new int[n+1][cap+1];
		for(int i = 1; i <= n; i++) {
			for(int c = 1; c <= cap; c++) {
				if(wgt[i-1] > c) {
					dp[i][c] = dp[i-1][c];
				}else {
					dp[i][c] = Math.max(dp[i-1][c], dp[i-1][c-wgt[i-1]]+val[i-1]);
				}
			}
		}
		return dp[n][cap];
	}
	public int dp2(int[] wgt, int[] val, int cap) {
		int n = wgt.length;
		int[] dp = new int[cap+1];
		for(int i = 1; i <= n; i++) {
			for(int c = cap; c >=1 ; c--) {
				dp[c] = Math.max(dp[c], dp[c - wgt[i-1]] + val[i-1]);
			}
		}
		return dp[cap];
	}
	
}

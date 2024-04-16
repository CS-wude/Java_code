package one_month;

public class Hello_DP_climbdp {
	public int climb_dp(int n) {
		if(n == 1 || n == 2)
			return n;
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	public int climb_dp2(int n) {
		if(n == 1 || n == 2) {
			return n;
		}
		int a = 1,  b = 2;
		for(int i = 3; i <= n; i++) {
			int tmp = b;
			b = a + b;
			a = tmp;
		}
		return b;
	}
}

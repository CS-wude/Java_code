package one_month;

public class Hello_DP_ClimbMinCost {
	public int mincost(int[] cost) {
		int n = cost.length - 1;
		if(n == 1 || n == 2)
			return cost[n];
		int[] dp = new int[n + 1];
		dp[1] = cost[1];
		dp[2] = cost[2];
		for(int i = 2; i <= n; i++) {
			dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
		}
		return dp[n];
	}
	public int mincost2(int[] cost) {
		int n = cost.length - 1;
		if(n == 1 || n == 2)
			return cost[n];
		int a = cost[1];
		int b = cost[2];
		for(int i = 2; i <= n; i++) {
			int tmp = b;
			b = Math.min(a, b) + cost[i];
			a = tmp;
		}
		return b;
	}
}

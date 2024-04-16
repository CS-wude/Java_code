package one_month;

public class Hello_DP_climbdfs {
	public int dfs(int i) {
		if(i == 1 || i == 2) {
			return i;
		}
		int count = dfs(i-1) + dfs(i-2);
		return count;
	}
	public int climb_dfs(int n) {
		return dfs(n);
	}
}

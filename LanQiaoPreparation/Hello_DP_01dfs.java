package one_month;

public class Hello_DP_01dfs {
	public int dfs(int[] wgt, int[] val, int i, int c) {
		if(i == 0 || c == 0) {
			return 0;
		}
		if(wgt[i-1] > c) {
			return dfs(wgt, val, i-1, c);
		}
		int no = dfs(wgt, val, i-1 ,c);
		int yes = dfs(wgt, val, i-1, c - wgt[i-1]) + val[i-1];
		return Math.max(no, yes);
	}
}

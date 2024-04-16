package one_month;

import java.util.Arrays;

public class Hello_DP_climbdfs2 {
	public int dfs(int i , int[] mem) {
		if(i == 1 || i == 2) {
			return i;
		}
		if(mem[i] != -1)
			return mem[i];
		int count = dfs(i-1, mem) + dfs(i-2, mem);
		mem[i] = count;
		return count;
	}
	public int climb_dfs2(int n) {
		int[] mem = new int[n+1];
		Arrays.fill(mem, -1);
		return dfs(n,mem);
	}
}

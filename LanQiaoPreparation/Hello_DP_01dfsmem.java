package one_month;

public class Hello_DP_01dfsmem {
	public int dfsmem(int[] wgt, int[] val, int[][] mem, int i, int c) {
		if(i == 0 || c == 0) {
			return 0;
		}
		if(mem[i][c] != -1) {
			return mem[i][c];
		}
		if(wgt[i-1] > c) {
			return dfsmem(wgt, val, mem, i-1, c);
		}
		int no = dfsmem(wgt, val, mem, i-1, c);
		int yes = dfsmem(wgt, val, mem, i-1, c- wgt[i-1]) + val[i-1];
		mem[i][c] = Math.max(no, yes);
		return mem[i][c];
	}
}

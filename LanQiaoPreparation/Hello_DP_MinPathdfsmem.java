package one_month;

public class Hello_DP_MinPathdfsmem {
	public int dfsmem(int[][] grid, int[][] mem, int i, int j) {
		if(i == 0 && j == 0) {
			return grid[0][0];
		}
		if(i <0 || j < 0) {
			return Integer.MAX_VALUE;
			
		}
		int up = dfsmem(grid, mem, i-1, j);
		int left = dfsmem(grid, mem, i, j-1);
		mem[i][j] = Math.min(left, up) + grid[i][j];
		return mem[i][j];
	}
}

package one_month;

public class Hello_DP_MinPathdfs {
	public int mindfs(int[][] grid, int i, int j) {
		if(i == 0 && j == 0) {
			return grid[0][0];
		}
		if(i <0 || j  < 0) {
			return Integer.MAX_VALUE;
		}
		int up = mindfs(grid, i -1, j);
		int left = mindfs(grid, i, j-1);
		return Math.min(left, up) + grid[i][j];
	}
}

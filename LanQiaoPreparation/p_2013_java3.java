package one_month;

public class p_2013_java3 {
	public static int dfs(int i , int j) {
		if(i == 3 || j == 4) {
			return 1;
		}
		return dfs(i+1, j) + dfs(i, j+1);
	}
	public static void main(String[] args) {
		System.out.println(dfs(0,0));	}
}

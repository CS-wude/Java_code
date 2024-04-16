package one_month;

public class day17_GamerMap {
	static long num = 0;
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		dfs(i , j);
		System.out.println(num);
	}
	public static void dfs(int i, int j) {
		if(i == 20 || j == 20) {
			num++;
			return;
		}
		i++;
		dfs(i ,j);
		i--;
		j++;
		dfs(i, j);
		j--;
		return;
	}
}

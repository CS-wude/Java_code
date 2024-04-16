package one_month;

import java.util.Scanner;

public class p_2014_java9 {
	static int n , m, k, num;
	static int[][] a = new int[55][55];
	public static void dfs(int i, int j, int currentK, int maxn) {
		if(currentK > 13) return;
		if(currentK == k) {
			if((i == n && j == m-1) || (i == n-1 && j == m)) {
				num++;
				return;
			}
		}
	}
	public static void main(String[] args) {
		
	}
}

package one_month;

import java.util.Arrays;
import java.util.Scanner;

public class day13j13_MinKNum {
	static int s = 0,k,n,m;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		long[] A = new long[n];
		long[] B = new long[m];
		boolean[][] selected = new boolean[n][m];
		for(int i = 0; i <n ; i++) {
			A[i] = scan.nextLong();
		}
		for(int i = 0; i < m; i++) {
			B[i] = scan.nextLong();
		}
		Arrays.sort(A);
		Arrays.sort(B);
		dfs(A,B,selected,0,0);
		scan.close();
		
	}
	public static void dfs(long[] A ,long[] B,boolean[][] selected,int p, int q) {
		for(int i = p; i < n; i++) {
			for(int j = q; j < m; j++) {
				s++;
				if((i < n-1) && (j < m) && ((A[i] + B[j]) > (A[i+1] + B[j])) && (selected[i][j] == false) && (selected[j][i] == false)) {
					selected[i+1][j] = true;
					if(s ==  k+1) {
						System.out.println(A[i+1] + B[j]);
						return;
					}
					dfs(A,B,selected,i+1,j);
				}
				if(s ==  k+1) {
					System.out.println(A[i] + B[j]);
					return;
				}
			}
		}
	}
}

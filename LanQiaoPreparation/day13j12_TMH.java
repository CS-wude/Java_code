package one_month;

import java.util.ArrayList;
import java.util.List;

public class day13j12_TMH {
	static int max = 0;
	public static void main(String[] args) {
		int[] a = new int[1001];
		a[1] = 1;
		for(int i = 2; i <1000;i++) {
			a[i] = a[i-1]*2;
		}
		int N = 0;
		for(int i = 1; i <= 500 ;i++) {
			int j = 1000-i;
			int m = 0,n = 0;
			dfs(m,n,a,j,i);
			if(m >= max) {
				if(m > max) {

					N = 0;
					N += i;
				}
				if(m == max) {
					N += i;
				}
			}
		}
		System.out.println(N);
	}
	public static void dfs(int m,int n, int[] a, int j, int i) {
		if(i == 0) {
			m += n;
			return;
		}
		for(int p = 1; p <= j; p++) {
			n+=a[p];
			dfs(m, n, a, j, i-1);
			n-= a[p];
		}
	}
}

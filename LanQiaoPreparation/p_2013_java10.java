package one_month;

import java.util.Scanner;

public class p_2013_java10 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int maxx, minn;
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = cin.nextInt();
		}
		int count = 0;
		for(int i = 0; i < n; i++) {
			maxx = minn = a[i];
			for(int j = i; j < n; j++) {
				maxx = Math.max(maxx, a[j]);
				minn = Math.min(minn, a[j]);
				if(maxx- minn == j-i) count++;
			}
		}
		System.out.println(count);
	}
}

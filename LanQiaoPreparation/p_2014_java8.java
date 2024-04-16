package one_month;

import java.util.Scanner;

public class p_2014_java8 {
	public static boolean checkVector(int a[], int n) {
		int t = a[0];
		for(int i = 1; i < n; i++) {
			if(t != a[i]) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = cin.nextInt();
		}
		int sum = 0;
		while(true) {
			if(checkVector(a, n)) break;
			for(int i = 0; i < n ; i++) a[i] /= 2;
			int t = a[0];
			for(int i = 0; i < n; i++) {
				if(i < n-1) {
					a[i] += a[i+1];
				}
				else {
					a[i] += t;
				}
				if(a[i] % 2 == 1) {
					sum++;
					a[i]++;
				}
			}
		}
		System.out.println(sum);
	}
}

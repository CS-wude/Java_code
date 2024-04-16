package one_month;

import java.util.Scanner;

public class day13j13_CowDisease {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] x = new int[n];
		int[] s = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = scan.nextInt();
			s[i] = scan.nextInt();
		}
		bubblesort(x,s,n);
		int min0 = 10000000;
		for(int i = 0; i < n-1; i++) {
			if(s[i] != s[i+1]) min0 = Math.min(min0, x[i+1] - x[i]);
		}
		int num = 0;
		if(s[0] == 1) num++;
		for(int i = 1; i < n; i++) {
			if(s[i] == 1) {
				if(s[i-1] == 0) {
					num++;
				}else if((x[i] - x[i-1]) >= min0) {
					num++;
				}
			}
		}
		System.out.println(num);
		scan.close();
		
	}
	public static void bubblesort(int[] x, int[] s, int n) {
		boolean flag = false;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-1; j++ ) {
				if(x[j] > x[j+1]) {
					int tmp = x[j];
					int tmp2 = s[j];
					x[j] = x[j+1];
					x[j+1] = tmp;
					s[j] = s[j+1];
					s[j+1] = tmp2;
					flag = true;
				}
			}
			if(flag == false) return;
			else flag = false;
		}
	}
}

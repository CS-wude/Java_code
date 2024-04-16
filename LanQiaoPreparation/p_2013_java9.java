package one_month;

import java.util.Scanner;

public class p_2013_java9 {
	static int[] a = new int[10];
	static boolean[] b = new boolean[10];
	static int num,n;
	public static void dfs(int start) {
		if(start == 9) {
			for(int i = 1; i < 8; i++) {
				for(int j = i; j < 8; j++) {
					int num1 = 0,num2 = 0, num3 = 0;
					for(int k = 0; k < i; k++) {
						num1 = num1*10 + a[k];
					}
					for(int k = i; k < j; k++) {
						num2 = num2*10 + a[k];
					}
					for(int k = j+1; k <= 8; k++) {
						num3 = num3*10 + a[k];
					}
					if(num2 % num3 == 0) {
						if(num2/num3 + num1 == n) {
							num++;
						}
					}
				}
			}
		}
		for(int i = 1; i < 10; i++) {
			if(!b[i]) {
				b[i] = true;
				a[start] = i;
				dfs(start + 1);
				b[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		dfs(0);
		System.out.println(num);
	}
}

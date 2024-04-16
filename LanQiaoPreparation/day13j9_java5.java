package one_month;

import java.util.Scanner;

public class day13j9_java5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		if(N == 1) System.out.println(arr[0]);
		else {
			int A = 0, B = 0;
		for(int i = 0; i < N-1; i ++) {
			B = 0;
			int a = arr[i];
			B += a;
			for(int j = 1; j < N; j++) {
					if(a <= arr[j]) {
						B += arr[j];
						a = arr[j];
					}
				}
			A = Math.max(A, B);
			}
		System.out.println(A);
		}
		scan.close();
	}
}

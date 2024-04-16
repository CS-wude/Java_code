package one_month;

import java.util.Scanner;

public class day7_BlueDrinking {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		q = scan.nextInt();
		int wmin = 1000;
		for(int i = 0; i < n; i++) {
			int w = scan.nextInt();
			wmin = Math.min(w, wmin);
		}
		if(q < 10) System.out.println(q + wmin);
		else System.out.println(10 + wmin);
		scan.close();
	}
}

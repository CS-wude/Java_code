package one_month;

import java.util.Scanner;

public class day13j9_java1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i = 0 ; i< T; i++) {
			double N = scan.nextDouble();
			double X = scan.nextDouble();
			if((N/2) < X) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

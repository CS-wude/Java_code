package one_month;

import java.util.Scanner;

public class day18_NKX {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long N = scan.nextLong();
		long K = scan.nextLong();
		long X = scan.nextLong();
		long min = 0;
		long max = 0;
		if(N < K ) {
			System.out.println("No");
		} else {
			
			for(long i = 1; i <= K ; i++) {
				min += i;
			}
			for(long i = N-K+1; i <= N; i++) {
				max += i;
			}
			if(X >= min && X <= max) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		scan.close();
	}
}

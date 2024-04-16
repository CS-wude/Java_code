package one_month;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class day13j12_DYSJX {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] A = new long[n];
		long[] B = new long[n];
		for(int i = 0; i < n; i++) {
			A[i] = scan.nextLong();
		}
		for(int i = 0; i < n; i++) {
			B[i] = scan.nextLong();
		}
		int s = 0;
		
		Set<Long> sa = new HashSet<>();
		Set<Long> sb = new HashSet();
		for(int i = 0; i < n; i++) {
			sa.add(A[i]);
			sb.add(B[i]);
		}
		A = new long[sa.size()];
		B = new long[sb.size()];
		int i = 0;
		for(Long l : sa) {
			A[i] = l;
			i++;
		}
		i = 0;
		for(Long l : sb) {
			B[i] = l;
			i++;
		}
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int t = 0 ; t < B.length; t++) {
			for(int j = 0; j < A.length; j++) {
				for(i = j; j < A.length; j++) {
					if(((A[i] + A[j]) > B[t]) && ((A[i] + B[t]) > A[j])) s++;
				}
			}
		}
		
		System.out.println(s);
		scan.close();
	}
}

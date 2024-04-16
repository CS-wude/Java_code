package one_month;

import java.util.Arrays;
import java.util.Scanner;

public class day13j9_java4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		int[] brr = arr;
		Arrays.sort(brr);
		boolean flag = true,fff = true;
		if(N == 1)  fff = false;
		if((N%2 == 1) && brr[N/2] != arr[N/2]) flag = false;
		if(fff == false) {
			System.out.println("YES");
		}else {
			
		
		if(flag == true) {
			for(int i = 0; i < N/2; i++) {
				if(((arr[i] == brr[i]) && (arr[N-i-1] == brr[N-i-1])) || ((arr[i] == brr[N-i-1]) && (arr[N-i-1] == brr[i]))) {
					
				}else {
					flag = false;
					System.out.println("NO");
					break;
				}
			}
			if(flag == true) System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
		
	}
}

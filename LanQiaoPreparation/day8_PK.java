package one_month;

import java.util.Scanner;

public class day8_PK {
	public static void main(String[] agrs) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] lanT = new int[n];
		int[][] qiao = new int[n][2];
		int[] lanG = new int[n];
		for(int i = 0; i < n; i++) {
			lanT[i] = scan.nextInt();
			qiao[i][0] = scan.nextInt();
			qiao[i][1] = scan.nextInt();
			int j = lanT[i]/qiao[i][1];
			if((lanT[i] % qiao[i][1]) != 0) j++;
			lanG[i] = qiao[i][0]/j;
			if((qiao[i][0] % j) != 0) lanG[i]++;
		}
		for(int i = 0; i < n; i++) {
			System.out.println(lanG[i]);
		}
		
		scan.close();
	}
}

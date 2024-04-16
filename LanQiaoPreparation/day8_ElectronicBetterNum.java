package one_month;

import java.util.Scanner;

public class day8_ElectronicBetterNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[][] Map = new int[N+1][N+1];
		//max1是高位，max2是低位
		int max1 = 1000000000;
		int max2 = 1000000000;
		
		//jk放余项，kj放进位
		for(int i = 0; i < M; i++) {
			int j = scan.nextInt();
			int k = scan.nextInt();
			if(j > k) {
				int tmp = j;
				j = k;
				k = tmp;
			}
			int num = scan.nextInt();
			//tmp1是高位，tmp2是低位
			int tmp1 = num/10000009;
			int tmp2 = num%10000009;
			tmp1 += (Map[j][k] + tmp2)/10000009;
			Map[j][k] = (Map[j][k] + tmp2)%10000009;
			Map[k][j] += tmp1;
			tmp1 = Map[k][j];
			if(tmp1 <= max1) {
				if(tmp2 <= max2) {
					max1 = tmp1;
					max2 = tmp2;
				}
			}
		}
			System.out.println(max2);
		
		scan.close();
	}
}

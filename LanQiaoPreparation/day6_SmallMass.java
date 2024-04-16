package one_month;

import java.util.Scanner;

public class day6_SmallMass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int[] mass = new int[K+1];
		int[] tool = new int[N]; 
		//去找能初始化数组为0的办法
		for(int i = 0; i <= K; i++) {
			mass[i] = 0;
		}
		for(int i = 0; i < N; i++) {
			int j = scan.nextInt();
			mass[j] = 1;
		}
		int u = 0;
		for(int i = 0; i <= K; i++) {
			if(mass[i] == 1) {
				tool[u] = i;
				u++;
			}
		}
		for(int i = 0; i <= K; i++) {
			System.out.print(mass[i]);
		}
		System.out.println("");
		for(int i = 0; i < N; i++) {
			System.out.print(tool[i]);
		}
		System.out.println("");
		for(int i = 1; i <= K; i++) {
			for(int j = 0; j < N; j++) {
				if(i-tool[j] > 0) {
					mass[i] += mass[i - tool[j]];
				}
			}
		}
		System.out.println(mass[K]);
		
		scan.close();
	}
}

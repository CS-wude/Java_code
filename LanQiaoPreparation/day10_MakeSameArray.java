package one_month;

import java.util.Scanner;
//结果错误，仔细一看，这是数列，没有顺序可言
//Arrays.sort(数组)可以将数组排序
//还有个技巧不用判断两数大小直接相减：Math.abs(a-b)
public class day10_MakeSameArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = scan.nextInt();
		}
		int num = 0;
		for(int i = 0; i < n; i++) {
			int B = scan.nextInt();
			if(B > A[i]) {
				num += (B - A[i]);
			}else {
				num += (A[i] - B);
			}
		}
		System.out.println(num);
		scan.close();
	}
}

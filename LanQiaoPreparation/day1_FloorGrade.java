package one_month;

import java.util.Scanner;

public class day1_FloorGrade {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//int n = scan.nextInt();
		/*
		 * 写完动态规划后发现这题好像不是动态规划的1、2、3
		 * int a = scan.nextInt(); int b = scan.nextInt(); int c = scan.nextInt();
		 */
		
		//试试动态规划
		int n = 4;
		System.out.println(DP(4));
		
		scan.close();
	}
	//三个变量跑出来也不是正确结果，代码shishang
	public static int DP(int n) {
		if(n == 1 || n == 2 || n == 3) {
			return n;
		}
		//初始化dp表
		int[] dp = new int[n+1];
		
		//初始状态
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		//使用滚动变量
		/*
		 * int q = 1; int w = 2; int e = 3;
		 */
		
		//状态转移
		for(int i = 4; i <= n; i++) {
			 dp[i] = dp[i-1] + dp[i-2] +dp[i-3]; 
			/*
			 * int tmp = e; e = q + w + tmp; q = w; w = tmp;
			 */
		}
		return dp[n];
		//return e;
	}
}

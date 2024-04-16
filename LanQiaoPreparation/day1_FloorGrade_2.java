package one_month;

import java.util.Scanner;

//正确但超时
public class day1_FloorGrade_2 {
	static int num = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] nums = new int[3];
		for(int i = 0; i < 3; i++) {
			nums[i] = scan.nextInt();
		}
		
		//试试回溯
		trace(n, nums);
		num %= 1000000007;
		System.out.println(num);
		
		
		scan.close();
	}
	public static void trace(int n, int[] nums) {
		if(n <= 0) {
			if(n == 0) num++;
			return;
		}
		for(int i = 0; i < 3; i++) {
			n -= nums[i];
			trace(n, nums);
			n += nums[i];
		}
	}
}

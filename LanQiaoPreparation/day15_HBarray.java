package one_month;

import java.util.Arrays;

public class day15_HBarray {
	public static void main(String[] args) {
		
	}
	public static int count(int[][] arr) {
		Arrays.sort(arr, (a, b) -> a[0]-b[0]);
		int ans = 0;
		int max = -1;
		for(int[] a: arr) {
			if(a[0] > max) {
				ans = ans*2%1000000007;
				
			}
			max = Math.max(max, a[1]);
			
		}
		return ans;
	}
}

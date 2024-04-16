package one_month;

import java.util.Scanner;

public class day17_XiaoXinCook {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String[] str = new String[N];
		for(int i = 0; i < N; i++) {
			str[i] = scan.next();
		}
		int[] num = new int[6];
		for(int i = 0; i < N; i++) {
			String s = str[i];
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == 'l') {
					num[0]++;
					//System.out.println("OK");
				}
				if(s.charAt(j) == 'a') num[1]++;
				if(s.charAt(j) == 'n') num[2]++;
				if(s.charAt(j) == 'q') num[3]++;
				if(s.charAt(j) == 'i') num[4]++;
				if(s.charAt(j) == 'o') num[5]++;
			}
		}
		int n = 1000000000;
		num[1] /= 2;
		for(int i = 0; i < 6; i++) {
			n = Math.min(num[i] , n);
			
		}
		System.out.println(n);
		scan.close();
	}
}

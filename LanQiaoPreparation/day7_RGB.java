package one_month;

import java.util.Scanner;

public class day7_RGB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String str1 = scan.next();
		String str2 = scan.next();
		int[] s1 = new int[3];
		int[] s2 = new int[3];
		
		for(int i = 0; i < n; i++) {
			if(str1.charAt(i) == 'R') s1[0]++;
			if(str1.charAt(i) == 'G') s1[1]++;
			if(str1.charAt(i) == 'B') s1[2]++;
			if(str2.charAt(i) == 'R') s2[0]++;
			if(str2.charAt(i) == 'G') s2[1]++;
			if(str2.charAt(i) == 'B') s2[2]++;
		}
		if(s1[0] == s2[0] && s1[1] == s2[1] && s1[2] == s2[2]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		scan.close();
	}
}

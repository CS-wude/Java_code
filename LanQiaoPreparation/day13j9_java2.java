package one_month;

import java.util.Scanner;

public class day13j9_java2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		boolean flag = false;
		String ans = "";
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'L') {
				if(flag == true)
				continue;
				if(flag == false) {
					flag = true;
					ans += c;
				}
			}
			if(c == 'Q') ans += c;

		}
		System.out.println(ans);
		scan.close();
	}
}

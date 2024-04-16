package one_month;

import java.util.Scanner;

public class day13j9_java3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int ans = 0, an = 0;
		for(int i = A; i <= B; i++) {
			while(true) {
				int t = i%10;
				if(t == 8) an += 2;
				if(t == 0 || t == 6 || t == 9) an +=1;
				i /= 10;
				if(i == 0) break;
			}
			ans = Math.max(ans, an);
		}
		System.out.println(ans);
		scan.close();
	}
}

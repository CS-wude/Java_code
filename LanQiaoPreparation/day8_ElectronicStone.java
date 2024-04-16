package one_month;

import java.util.*;

public class day8_ElectronicStone {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int day = (n / 6) * 3;
		n %= 6;
		if(n != 0  ) {
			day++;
		 if(n != 1 && n != 2) {
			 	day++;
		 	}
		}
		System.out.println(day);
	}
}

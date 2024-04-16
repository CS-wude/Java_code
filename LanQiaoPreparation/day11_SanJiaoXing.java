package one_month;

import java.util.Scanner;
import java.math.BigInteger;

public class day11_SanJiaoXing {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] Str = str.split(" ");
		BigInteger a = new BigInteger(Str[0]);
		BigInteger b = new BigInteger(Str[1]);
		BigInteger c = new BigInteger(Str[2]);
		/*
		 * int a = scan.nextInt(); int b = scan.nextInt(); int c = scan.nextInt();
		 */
		if((c.min((a.subtract(b)).abs()) == c) && (a.min((c.subtract(b)).abs()) == a) && (b.min((a.subtract(c)).abs()) == b)) {
		//if((Math.abs(a-b) < c) && (Math.abs(c-b) < a) && (Math.abs(a-c) < b)) {
			System.out.println(1);
		}else {
			System.out.println(0);		
			}
	}
}

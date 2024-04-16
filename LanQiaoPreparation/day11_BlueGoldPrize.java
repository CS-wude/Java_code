package one_month;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;

public class day11_BlueGoldPrize {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int j = scan.nextInt();
			list.add(j);
		}
		Collections.sort(list,(a, b)->Integer.compare(a, b));
		int m = n - ZS(n)-1;
		int sum = 0;
		//System.out.println(ZS(n));
		for(int i = m; i < n; i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
		
		scan.close();
	}
	public static int ZS(int n) {
		while(true) {
			int i = 2;
			for(; i < Math.sqrt(n); i++) {
				if(Math.sqrt(n) % i == 0) break;
			}
			if(i == Math.sqrt(n)) return n;
			n--;
		}
	}
}

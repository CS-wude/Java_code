package one_month;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p_2013_java7 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int n = cin.nextInt();
		String ss = cin.nextLine();
		for(int i = 0; i < n; i++) {
			String str = cin.nextLine();
			String[] num = str.trim().replaceAll("\\s+",",").split(",");
			for(int j = 0;j < num.length;j++) {
				arr.add(Integer.parseInt(num[j]));
			}
		}
		arr.sort(null);
		int x = 0, y = 0;
		for(int j = 1; j < arr.size(); j++) {
			if(arr.get(j) - arr.get(j-1) == 0) {
				y = arr.get(j);
			}
			if(arr.get(j) - arr.get(j-1) == 2) {
				x = arr.get(j) - 1;
			}
		}
		System.out.println(x + " " + y);
	}
}

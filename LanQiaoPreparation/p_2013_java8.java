package one_month;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p_2013_java8 {
	static int a,b;
	public static int getResult() {
		List<Integer> list = new ArrayList<>();
		List<Integer> arr = null;
		for(int i = 1; i < b; i++) {
			if(i % 2 == 1) {
				list.add(i);
			}
		}
		int k = 1;
		while(true) {
			int t = list.get(k++);
			arr = new ArrayList<>();
			for(int i = 0; i < list.size(); i++) {
				if(i % t != (t-1)) {
					arr.add(list.get(i));
				}
			}
			list = arr;
			if(t > list.size())
				break;
		}
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) > a && list.get(i) < b)
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		a = cin.nextInt();
		b = cin.nextInt();
		System.out.println(getResult());
	}
}

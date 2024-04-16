package one_month;

import java.util.Set;
import java.util.HashSet;

public class day1_SonOf2003 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		//set中add()返回Boolean型，如果存在则不加入该元素，返回false
		
		//这题问的是2023
		int i = 1;
		while(i < 2023) {
			if (2023 % i == 0) {
				set.add(i);
				set.add(2023/i);
			}
			i++;
		}
		//size()是set的数量
		System.out.println(set);
		System.out.println(set.size());
	}
}

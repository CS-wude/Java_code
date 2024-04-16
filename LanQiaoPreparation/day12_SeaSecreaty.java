package one_month;

import java.util.Scanner;

public class day12_SeaSecreaty {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String Str = scan.nextLine();
		int n = scan.nextInt();
		String[] str = new String[n];
		for(int i = 0; i < n; i++) {
			str[i] = scan.nextLine();
		}
		int M = Str.length();
		int[] strnum = new int[n];
		for(int j = 0; j < n; j++) {
			String s = str[j];
			int m = s.length();
			for(int i = 0; i <= (M-m); i++) {
				if(Str.regionMatches(false, i, s, 0, m) == true) strnum[j]++;
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.println(strnum[i]);
		}
	}
	//这个用的是indexOf我不理解为什么匹配字符能匹配字符串
	/*https://www.lanqiao.cn/problems/4050/learning/?page=1&first_category_id=1&tags=AC%E8%87%AA%E5%8A%A8%E6%9C%BA*/
}

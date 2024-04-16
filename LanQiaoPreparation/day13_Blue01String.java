package one_month;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/*不应该用set，这个可以重复,子串考虑位置*/
public class day13_Blue01String {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String str = scan.next();
		List<String> strs = getAllString(str);
		int num = 0;
		for(String s : strs) {
			//System.out.println(s);
			if(YON(s) == true) {
				num++;
				//System.out.println("yes");
			}
		}
		System.out.println(num);
		scan.close();
	}
	public static List getAllString(String str) {
		List strs = new ArrayList();
		if(str.length() == 0) return strs;
		for(int i = 0; i < str.length(); i++) {
			for(int j = i+1; j <= str.length(); j++) {
				strs.add(str.substring(i, j));
			}
		}
		return strs;
	}
	public static boolean YON(String str) {
		int n = str.length();
		if(n <= 1 || (n % 2) == 1) return false;
		int i = 0;
		int j = n-1;
		while(i < j) {
			if(str.charAt(i) == str.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}

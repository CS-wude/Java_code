package one_month;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class day5_ZChange {
	public static void mian(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		String str = scan.next();
		//num用处构造
		List<String> str1 = new ArrayList<String>(num); 
		//经过test修改后
		for(int i = 0; i < num; i++) {
			str1.add(i, "");
		}
		int len = str.length();
		int lendd = 0;
		for(int i = 0;lendd < len;) {

				String s1 = "";
				s1 += str.charAt(lendd);
				str1.add(i, str1.get(i)+s1);
				i++;
				lendd++;
				if(i == num) {
					i -= 2;
					while(i != 0 && lendd < len) {
						String s2 =  "";
						s2 += str.charAt(lendd);
						str1.add(i, str1.get(i)+s2);
						i--;
						lendd++;
						
					}
				}
			}
		String str2 = "";
		for(int i = 0; i < num; i++) {
			str2 += str1.get(i);
		}
		System.out.println(str2);
		scan.close();
	}
}

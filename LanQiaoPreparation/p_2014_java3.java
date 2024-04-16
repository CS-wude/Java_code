package one_month;

import java.math.BigDecimal;

public class p_2014_java3 {
	public static void main(String[] args) {
		StringBuffer str1 = new StringBuffer();
		for(int i = 0; i < 19; i++) {
			char c = (char)('a'+i);
			str1.append(c);
		}
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < 106; i++) {
			str.append(str1);
		}
		while(true) {
			str1 = new StringBuffer();
			if(str.length() == 1) break;
			for(int i = 0; i < str.length(); i++) {
				if(i % 2 == 0) str1.append(str.charAt(i));
				
			}
			str = str1;
		}
		System.out.println(str);
	}
}

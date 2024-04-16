package one_month;

import java.util.Calendar;

public class p_2013_java1 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		for(int year = 1999; year <= 9999; year += 100) {
			calendar.set(year, 11, 31);
			if(calendar.get(Calendar.DAY_OF_WEEK) == 1) {
				System.out.println(year);
				break;
			}
		}
	}
}

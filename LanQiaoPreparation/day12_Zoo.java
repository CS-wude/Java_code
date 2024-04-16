package one_month;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class day12_Zoo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] str = new String[n];
		//List list = new ArrayList();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			//String sss = scan.next();
			str[i] = scan.next();
			//list.add(sss);
			//System.out.println(list.get(i));
			//System.out.println(str[i]);
			nums[i] = NUM(str[i]);
			System.out.println(nums[i]);
			//System.out.println(121212);
		
		}
		//System.out.println("ok");
		
		
		scan.close();
	}
	public static int NUM(String s) {
		if(s.length() == 1) return 1;
		int l = s.length();
		//System.out.println(l);
		int[] num = new int[l];
		Arrays.fill(num, 1);
		//长度为1或者第一个就直接不看
		//List num = new ArrayList();
		for(int t = 1; t < s.length(); t++) {
			int i = t;
			int j = 0;
			String snum = s.substring(0, t+1);
			String a = "";
			String b = "";
			
			
			while(i > j) {
				a += snum.charAt(j);
				String tmp = b;
				b = "";
				b += snum.charAt(i);
				b += tmp;
				//System.out.println(a +"+"+ b);
				//if(a == b) { equals很重要
				if(a.equals(b)) {
					num[t] ++;
					//System.out.println("yes");
				}
				
				i--;
				j++;
				//System.out.println(num[t]);
			}
			num[t] %= 1000000007;
			a = "";
			b = "";
		}
		int n = 1;
		for(int i = 0; i < l; i++) {
			n *= num[i];
			n %= 1000000007;
			//System.out.println(num[i]);
		}
		//System.out.println(n);
		return n;
		
	}
}

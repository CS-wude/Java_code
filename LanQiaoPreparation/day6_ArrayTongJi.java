package one_month;

import java.util.Scanner;
import java.math.BigInteger;
/*
 * 未完成,在考虑动态规划*/
public class day6_ArrayTongJi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String[] strs = str.split(" ");
		//int modint = 1998244353;
		int l = 0,r = 0,k = 0;
		BigInteger mod = new BigInteger("998244353");
		for(int i = 0; i < 3; i++) {
			BigInteger bi = new BigInteger(strs[i]);
			bi = bi.mod(mod);
			//intValue()记住
			if(i == 0) l = bi.intValue();
			if(i == 1) r = bi.intValue();
			//这里想到一个如果k余了等于0怎么办，先不想这个了，假设他不会等于0
			if(i == 2) k = bi.intValue();
		}
		if(r <= l) r += 998244353;
		int s = l - r + 1;
		
		long[] dp = new long[s + 1];
		
		dp[0] = 1;
		//dp[1] 
		
		
		for(int i = 1; i <= s; i++) {
			
		}
		
		scan.close();
	}
}

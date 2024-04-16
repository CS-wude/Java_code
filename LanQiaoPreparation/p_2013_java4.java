package one_month;

import java.math.BigInteger;
import java.math.BigDecimal;

public class p_2013_java4 {
	public static void main(String[] args) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		for(int i = 0 ; i < 5000; i++) {
			BigInteger t = a.add(b);
			a= b;
			b = t;
			
		}
		BigDecimal aa = new BigDecimal(a);
		BigDecimal bb = new BigDecimal(b);
		BigDecimal bd = aa.divide(bb, 100, BigDecimal.ROUND_HALF_DOWN);
		System.out.println(bd);
	}
}

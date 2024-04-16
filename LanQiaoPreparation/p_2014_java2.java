package one_month;

public class p_2014_java2 {
	public static void main(String[] args) {
		int[] f = new int[100];
		f[0] = 2;
		f[1] = 3;
		for(int i = 2; i <= 10; i++) {
			f[i] = 2*f[i-1] - 1;
			
		}
		System.out.println(f[10]);
	}
}

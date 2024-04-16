package one_month;

import java.util.Scanner;

/*突然有个疑问，java中将变量带入方法中，方法里面有对变量进行操作，
 * 那方法结束后这些变量会得到操作后的变量嘛*/

public class day9_01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int num = 0;
		while(N != 0) {
			int maxn = maxN(N);
			maxn = N01(N, maxn);
			N -= maxn;
			num++;
		}
		System.out.println(num);
		scan.close();
	}
	public static int maxN(int N) {
		for(int i = 1000000000;;) {
			if(N/i != 0) return i;
			i /= 10;
		}
	}
	public static int N01(int N, int maxn) {
		int X = 1;
		while(N != 0) {
			if((N % 10 != 0) && (N/10 != 0)) maxn += (1 * X);
			N /= 10;
			X *= 10;
		}
		return maxn;
	}
}

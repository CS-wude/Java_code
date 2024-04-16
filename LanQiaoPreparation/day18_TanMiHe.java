package one_month;

public class day18_TanMiHe {
	public static void main(String[] args) {
		int j = 0;
		int max = 0;
		for(int i = 1; i < 500; i ++) {
			j = 1000 - i;
			j = (j + (j-i+1))*i/2;
			max = Math.max(max, j);
		}
		System.out.println(max);
	}
}

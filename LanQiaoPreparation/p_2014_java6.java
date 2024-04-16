package one_month;

public class p_2014_java6 {
	public static void main(String[] args) {
		int num = 0;
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				if(i != j)
					for(int k = 1; k <= 9; k++) {
						for(int t = 1; t <= 9; t++) {
							if(k != t) {
								if((i*10 + k)*j*t == i*k*(j*10 + t)) num++;
							}
						}
					}
			}
		}
		System.out.println(num);
	}
}

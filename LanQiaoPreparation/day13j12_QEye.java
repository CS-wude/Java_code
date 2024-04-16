package one_month;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day13j12_QEye {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int R = scan.nextInt();
		/*
		 * int[] x = new int[N]; int[] y = new int[N];
		 */
		List x = new ArrayList();
		List<ArrayList> y = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			if(x.contains(x1)) {
				y.get(x.indexOf(x1)).add(y1);
			}else {
				x.add(x1);
				List l = new ArrayList();
				l.add(y1);
				y.add((ArrayList) l);
			}
		}
		int num = 0;
		for(int i = 0; i < y.size(); i++) {
			List l = y.get(i);
			for(int j = 0; j < l.size(); j++) {
				int t = (int)(l.get(j))*(-1);
				if(x.contains(t)) {
					List l2 = y.get(x.indexOf(t));
					int t2 = (int)x.get(i) * (-1);
					if(l2.contains(t2)) num++;
				}
			}
		}
		/*
		 * int num2 = (1+N-1)*(N-1)/2; num2 -= num; System.out.println(num2);
		 */
		System.out.println(num);
		scan.close();
		
	}
}

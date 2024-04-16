package one_month;

public class p_2013_java6 {
	static void sort(int[] x) {
		int p = 0;
		int left = 0;
		int right = x.length -1 ;
		
		while(p <= right) {
			if(x[p] < 0) {
				int t = x[left];
				x[left] = x[p];
				x[p] = t;
				left++;
				p++;
			}else if(x[p] > 0) {
				int t = x[right];
				x[right] = x[p];
				x[p] = t;
				right--;
			} else {
				p++;
			}
		}
	}
	public static void main(String[] args) {
		int[] x = {25, 18,0, -5, 33, 22};
		sort(x);
		
	}
}

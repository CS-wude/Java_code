package one_month;

public class day13j12_bubblesort {
	public static void main(String[] args) {
		int[] a = new int[5];
		boolean flag = false;
		for(int i = 0; i < a.length-1; i++) {
			
			for(int j = 0; i < a.length-1; j++) {
				if(a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					flag = true;
				}
			}
			if(flag == true) {
				flag = false;
			} else {
				break;
			}
		}
	}
}

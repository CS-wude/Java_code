package one_month;

public class p_2013_java2 {
	static boolean[] b = new boolean[10];
	static int[] a = new int[10];
	static int num;
	
	public static void dfs(int start) {
			if(start == 5) {
				if((a[0]*10+a[1])*(a[2]*100+a[3]*10+a[4]) == (a[2]*10+a[4])*(a[0]*100+a[3]*10+a[1])) {
					num++;
					return;
				}
			}
			for(int i = 1; i < 10; i++) {
				if(!b[i]) {
					b[i]=true;
					a[start]=i;
					dfs(start+1);
					b[i]=false;
				}
			}
	}
	public static void main(String[] args) {
		num = 0;
		dfs(0);
		System.out.println(num);
	}
}

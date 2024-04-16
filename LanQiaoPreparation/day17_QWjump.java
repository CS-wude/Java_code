package one_month;

import java.util.Scanner;
//再次强调，string中的equals很重要
public class day17_QWjump {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] ch = new String[n+1];
		for(int i = 1; i <= n; i++) {
			ch[i] = scan.next();
			//System.out.println(ch[i]);
		}
		int[] ans = F(n);
		//System.out.println(ans[1]+" " + ans[2] + " " + ans[3] +" " + ans[4]);
		int[] site = Count(ans, ch, n);
		System.out.print(site[0] + " " + site[1]);
		
	}
	public static int[] F(int n) {
		int[] ans = new int[n+1];
		ans[1] = 1;
		if(n == 1) return ans;
		ans[2] = 1;
		if(n == 2) return ans;
		for(int i = 3; i <= n; i++) {
			ans[i] = ans[i-1] + ans[i-2];
			//System.out.println(ans[i]);
		}
		return ans;
	}
	public static int[] Count(int[] ans, String[] ch, int n) {
		int[] site = new int[2];
		site[0] = 0;
		site[1] = 0; 
		//site[0] -= 1;
		for(int i = 1 ; i <= n; i++) {
			if(ch[i].equals("U")) {
				site[1] += ans[i];
				//System.out.println("U");
			}
			if(ch[i].equals("D")) {
				site[1] -= ans[i];
				//System.out.println("D");
			}
			
			if(ch[i].equals("L")) {
				site[0] -= ans[i];
				//System.out.println("L");
			}
			
			if(ch[i].equals("R")) {
				site[0] += ans[i];
				//System.out.println("R");
			}
			
			//System.out.println(site[0] +" " + site[1]);
		}
		return site;
	}
}

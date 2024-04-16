package one_month;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class day13j9_java6 {
	static int ans = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Set set = new HashSet();
		int[] arr = new int[N];
		for(int i = 0 ; i <N; i++ ) {
			arr[i] = scan.nextInt();
			
		}
		Arrays.sort(arr);
		for(int i = 0 ; i <N; i++ ) {
			set.add(arr[i]);
		}
		for(int i = 2; i <= set.size(); i++) {
			dfs(0, i, set);
		}
		ans += N;
		ans %= 1000000000;
		ans += 7;
		System.out.println(ans);
		scan.close();
	}
	public static void dfs(int start, int i, Set set) {
		if(i == 0) {
			ans++;
			ans %= 1000000000;
			ans += 7;
			return;
		}
		for(int j = start; j < set.size(); j++) {
			dfs(start + 1, i -1, set);
		}
	}
}

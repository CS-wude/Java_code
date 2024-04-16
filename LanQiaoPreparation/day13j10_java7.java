package one_month;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day13j10_java7 {
	static int ans = 0;
	static int N,M,K;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		K = scan.nextInt();

		dfs(new ArrayList());
		System.out.println(ans);
		scan.close();
	}
	public static void dfs( List<Integer> choices ) {
		if(choices.size() == N) {
			for(int j = 0; j < N-1; j++) {
				if(Math.abs(choices.get(j+1) - choices.get(j)) < K) return;
			}
			ans++;
			ans %= 998244353;
			return;
		}
		for(int j = 1; j <= M; j++) {
			choices.add(j);
			dfs(choices);
			choices.remove(choices.size() - 1);
		}
	}
}

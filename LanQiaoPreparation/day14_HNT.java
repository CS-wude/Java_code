package one_month;

import java.util.List;

public class day14_HNT {
	public static void move(List<Integer> src, List<Integer> tar) {
		Integer pan = src.remove(src.size() - 1);
		tar.add(pan);
	}
	public static void dfs(int i, List<Integer> src, List<Integer> buf, List<Integer> tar) {
		if(i == 1) {
			move(src, tar);
			return;
		}
		dfs(i-1, src, tar, buf);
		move(src, tar);
		dfs(i-1, buf, src, tar);
	}
	public static  void solveHanota(List<Integer> A, List<Integer> B, List<Integer> C) {
		int n = A.size();
		dfs(n, A, B, C);
	}
	public static void main(String[] args) {
		
	}
}

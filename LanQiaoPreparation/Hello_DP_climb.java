package one_month;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hello_DP_climb {
	public void backtrack(List<Integer> choices, int state, int n, List<Integer> res) {
		if(state == n)
			res.set(0,  res.get(0)+1);
		for(Integer choice : choices) {
			if(state + choice > n)
				continue;
			backtrack(choices, state + choice, n, res);
		}
	}
	public int climbing(int n) {
		List<Integer> choices = Arrays.asList(1, 2);
		int state = 0;
		List<Integer> res = new ArrayList<>();
		res.add(0);
		backtrack(choices, state, n, res);
		return res.get(0);
	}
}

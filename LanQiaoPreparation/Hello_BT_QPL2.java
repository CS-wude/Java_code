package one_month;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hello_BT_QPL2 {
	public void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
		if(state.size() == choices.length) {
			res.add(new ArrayList<Integer>(state));
			return;
		}
		Set<Integer> duplicated = new HashSet<Integer>();
		for(int i = 0; i < choices.length; i++) {
			int choice = choices[i];
			if(!selected[i] && !duplicated.contains(choice)) {
				duplicated.add(choice);
				selected[i] = true;
				state.add(choice);
				backtrack(state, choices, selected, res);
				selected[i] = false;
				state.remove(state.size() - 1);
			}
		}
	}
	public List<List<Integer>> permutationsII(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
		return res;
	}
}

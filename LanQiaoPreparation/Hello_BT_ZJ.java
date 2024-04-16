package one_month;

import java.util.ArrayList;
import java.util.List;

public class Hello_BT_ZJ {
	public void backtrack(List<Integer> state, int target, int total, int[] choices, List<List<Integer>> res) {
		if(total == target) {
			res.add(new ArrayList<>(state));
			return;
		}
		for(int i = 0; i < choices.length; i++) {
			if(total + choices[i] > target) {
				continue;
			}
			state.add(choices[i]);
			backtrack(state, target, total+choices[i] , choices, res);
			state.remove(state.size() - 1);
		}
	}
	public List<List<Integer>> subsetSumINaive(int[] nums, int target){
		List<Integer> state = new ArrayList<>();
		int total = 0;
		List<List<Integer>> res = new ArrayList<>();
		backtrack(state, target, total, nums, res);
		return res;
	}
}

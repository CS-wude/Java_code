package one_month;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hello_BT_ZJ2 {
	public void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
		if(target == 0) {
			res.add(new ArrayList<>(state));
			return;
		}
		
		for(int i = start; i < choices.length; i ++) {
			if(target - choices[i] < 0) {
				break;
			}
			state.add(choices[i]);
			backtrack(state, target - choices[i], choices, i , res);
			state.remove(state.size() - 1);
		}
	}
	public List<List<Integer>> subsetSumII(int[] nums, int target){
		List<Integer> state = new ArrayList<>();
		Arrays.sort(nums);
		int start = 0;
		List<List<Integer>> res = new ArrayList<>();
		backtrack(state, target, nums, start, res);
		return res;
	}
}

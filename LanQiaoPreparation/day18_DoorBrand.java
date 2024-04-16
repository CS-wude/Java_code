package one_month;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class day18_DoorBrand {
	static int num = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] door = new int[n-1];
		Arrays.fill(door, 1);
		for(int i = 0; i < k; i++) {
			door[i] = 0;
		}
		backtrack(new ArrayList<Integer>(), door, new boolean[n-1], num );
		System.out.println(num);
		scan.close();
		
	}
	public static void backtrack(List<Integer> state, int[] choices, boolean[] selected, int num) {
		if(state.size() == choices.length) {
			//System.out.println(1);
			num++;
			return;
		}
		Set<Integer> duplicated = new HashSet<>();
		for(int i = 0; i < choices.length; i++) {
			int choice = choices[i];
			if(!selected[i] && !duplicated.contains(choice)) {
				duplicated.add(choice);
				selected[i] = true;
				state.add(choice);
				backtrack(state, choices, selected, num);
				selected[i] = false;
				state.remove(state.size() - 1);
			}
		}
		
	}
	
	
}

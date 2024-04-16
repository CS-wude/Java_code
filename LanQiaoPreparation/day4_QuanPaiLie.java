package one_month;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;

public class day4_QuanPaiLie {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		System.out.println(permutationsI(a));
		//无法排除重复，所以不能有相等元素
		int[] b = {1, 2, 2};
		System.out.println(permutationsI(b));
		
		//使用set
		int[] c = {1, 2, 2};
		System.out.println(permutationsII(b));
		
		int[] d = {1, 2, 2};
		System.out.println(permutationsIII(d));
		//这只是一个测试，事实证明int可以存这么大
		System.out.println(1000000000);
		int t = 1000000000;
		/*增加知识点:可以靠这个办法找最大公约数
		 * BigInteger
		 * gcd(BigInteger val) 
          返回一个 BigInteger，其值是 abs(this) 和 abs(val) 的最大公约数。
          abs() 
          返回其值是此 BigInteger 的绝对值的 BigInteger。*/
		BigInteger big = new BigInteger("1000000000");
		//我本以为找到了如何让BigInteger开根号，事实上我可能错了，暂时没找到
		System.out.println(Math.sqrt(t) + ","+big.pow((int)0.5));
		
		/*我又去学Integer了，我暂时只发现普通类型转String都是valueOf
		 * String则没有好的办法转普通
		 * 我现在试一下Integer.decode(String)转出Integer
		 * Integer又可以用intValue转int
		 * 事实证明，发生了强转
		 * 想象的事实被打败，详见day4_1_BlueMakeZhiNum
		 * 这个方法如其名，直接转ASCII
		 * 就算intValue也无用
		 * 后来实验又改变了我的想法，继续去看那个代码段*/
		int k1 = Integer.decode("1213");
		int k2 = Integer.decode("1213").intValue();
		System.out.println(k1);
		System.out.println(k2);
	}
	
	//无相等元素
	public static void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
		if(state.size() == choices.length) {
			res.add(new ArrayList<Integer>(state));
			return;
		}
		
		for(int i = 0; i < choices.length; i++) {
			int choice = choices[i];
			//剪枝
			if(!selected[i]) {
				//尝试:做出选择，更新状态
				selected[i] = true;
				state.add(choice);
				backtrack(state, choices, selected, res);
				selected[i] = false;
				state.remove(state.size() - 1);
			}
			
		}
	}
	
	//有相等元素
	public static void backtrack2(List<Integer> state, int[] choices, boolean[] selected, Set<List<Integer>> res) {
		if(state.size() == choices.length) {
			res.add(new ArrayList<Integer>(state));
			return;
		}
		
		for(int i = 0; i < choices.length; i++) {
			int choice = choices[i];
			//剪枝
			if(!selected[i]) {
				//尝试:做出选择，更新状态
				selected[i] = true;
				state.add(choice);
				backtrack2(state, choices, selected, res);
				selected[i] = false;
				state.remove(state.size() - 1);
			}
			
		}
	}
	
	//有相等元素（更优雅）
	public static void backtrack3(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
		if(state.size() == choices.length) {
			//这个步骤new ArrayList()很严谨，很容易忘记，如果直接state则会可能发生state被改变的错误
			res.add(new ArrayList(state));
			return;
		}
		Set<Integer> duplicated = new HashSet<Integer>();
		for(int i = 0; i < choices.length; i++) {
			int choice = choices[i];
			if(!selected[i] && !duplicated.contains(choice)) {
				duplicated.add(choice);
				selected[i] = true;
				state.add(choice);
				backtrack3(state, choices, selected, res);
				selected[i] = false;
				//remove的是size()-1不是i
				state.remove(state.size() - 1);
				
			}
		}
	}
	
	public static List<List<Integer>> permutationsI(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//这里的new用的很巧妙，节省了空间
		backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
		return res;
	}
	public static Set<List<Integer>> permutationsII(int[] nums){
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		backtrack2(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
		return res;
	}
	public static List<List<Integer>> permutationsIII(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack3(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
		return res;
	}
}

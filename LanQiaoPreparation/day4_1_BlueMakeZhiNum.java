package one_month;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.math.BigInteger;
/*
 * 这道题n的数码不包括0
 * 可以说是简化了
 * 如果包括0是不是需要考虑0在首位的情况
 * 不过我全排列将数码拆开了，后续组合成string应该不用担心这个问题,这应该是健壮性
 * 
 * 我突然想到我应该去多学习String的方法
 * 他们真的很有用处
 * 
 * bug：这次问题是String使用charAt()转int数组内
 * 转成了ascii，这里后续复盘一下*/
public class day4_1_BlueMakeZhiNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//String str = scan.next();
		int iii = scan.nextInt();
		//第一步：实现不同顺序，全排列
		//第五次
		int changdu = 0;
		int tmp = iii;
		while(tmp != 0) {

				changdu++;
				tmp /= 10;
			
		}
		//int[] nums = new int[str.length()];
		//for(int i = 0; i < str.length(); i++) {
		tmp = iii;
		int[] nums = new int[changdu];
		for(int i = 0; i < changdu; i++) {
		
			/*第四次直接跳第五次
			 * 看看是不是这里的问题
			 * 好，还真是这里
			 * 难道是char直接转int的问题嘛，那我第二次改的时候受否有问题，那时候我也想着char转int
			 * 我直接把next（）改int类型去了
			 * 一开始我也是担心int越界才用String的
			 * 不过后来我知道int还是能存蛮大的*/
			nums[i] = tmp%10;
			tmp /= 10;
			//System.out.println(nums[i]);第五次改完后成功
		}
		List<List<Integer>> res = permutations(nums);
		List<String> strs = new ArrayList<String>();
		/*突然想到一个是否能存储字符，如何将List<List>变为一个List
		 * 从而跳出for循环提高速度
		 * 但这里面不同数据的间隔标识符，即规则需要定义出来
		 * 首先还是解决如何存储字符char
		 * List<char> strss = new ArrayList<char>();*/
		for(List<Integer> state: res) {
			strs.add(Change(state));
		}
		
		int num = 0;
		
		for(String s : strs) {
			/*第一次结果错误：在这测试
			 * System.out.println(s);
			 * 输出
			 * 13
				4951
				5149
				1
				这是ASCII，那就是str转int哪里decode的问题
				它编码直接给我了这个玩意*/
			if(ZhiShu(s) == true) num++;
		}
		System.out.println(num);
		
		
	}
	
	public static void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res ) {
		if(state.size() == selected.length) {
			res.add(new ArrayList<Integer>(state));
			return ;
		
		}
		Set<Integer> duplicated = new HashSet<Integer>();
		for(int i = 0; i < choices.length; i++) {
			int choice = choices[i];
			//剪枝
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
	
	public static List<List<Integer>> permutations(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
		return res;
	}
	
	public static String Change(List<Integer> state){
		String str = "";
		for(int i : state) {
			str += i;
			//str += i; 第三次改动变了这里
			/*str += String.valueOf(i);
			 第四次：
			 * System.out.println(i);
			 * 好啊原来是这里的问题*/
		}
		/*第三次改：在这里先测试一下,果然要溯源到这里
		System.out.println(str);*/
		
		return str;
	}
	
	public static boolean ZhiShu(String str) {
		//这里的思考详见：day4_QuanPaiLie
		//BigInteger bi = new BigInteger(str);
		//for(int i = 0; i < bi.sqrt())
		
		/*int i = Integer.decode(str);
		int i = Integer.decode(str).intValue();也无用
		需要找个新的方法String转int*/
		
		/*第二次改这回我改成这样，让char强转int，小转大应该是合理的，但依旧是转了ASCII
		 * 这回我意识到不是这里的问题，应该是更前面的问题*/
		/*int i = 0;
		for(int t = 0; t < str.length(); t++) {
			i *= 10;
			i += str.charAt(t);
		}*/
		int i = Integer.decode(str);
		for(int j = 2; j < Math.sqrt(i); j++) {
			if(i % j == 0) return false;
		}
		return true;
	}
}

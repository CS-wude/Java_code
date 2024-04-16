package one_month;

import java.util.List;
import java.util.LinkedList;
/*
 * 一开始我使用的是嵌套循环，然后时间太久了都没出结果
 * 现在将嵌套分离,改善了速度
 * 但结果错误了，我又发现了我的问题，我没有真正理解质数 
 * 一个数是由大于它求根和小于它求根的和，质数没有中心那个值，有的话就是能开根号整数，不是质数
 * 所以只需要判断开根号小于部分的有无整数是因子，就可知道它是不是为质数*/
public class day3_SumOfZhiNum {
	public static void main(String[] args) {
		int sum = 1;
		List<Integer> list = new LinkedList<>();
		
		for(int i = 600; i < 1000000; i++) {

			/*
			 * 判断质数的错误方法
			 * if(i%2 != 0 &&i%3 != 0 &&i%5 != 0 &&i%7 != 0 ) { list.add(i); }
			 */
			int j = 2;
			//sqrt(double a) 
			for(; j < Math.sqrt(i); j++) {
				if(i % j == 0) break;
				
			}
			//这里我纠结了很久，后来想通了，这个是double，
			//j必须大于它，他若是一个无小数的则就直接说明他不是质数了
			if(i % j != 0 && j > Math.sqrt(i)) list.add(i);
		}
		//为什么这放在第二个复杂度呢，因为常数*（减小的n）比常数*n小太多了
		for(int i = 0; i < list.size(); i++) {
				int k = list.get(i);
				int t = k % 10;
				k /= 10;
				while(k != 0) {
					t += k % 10;
					k /= 10;
				}
				if (t == 23) sum++;
			
		}

		System.out.println(sum);
	}
}

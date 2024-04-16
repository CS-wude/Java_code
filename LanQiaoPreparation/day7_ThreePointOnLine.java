package one_month;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/*
 * 可能漏了哪里，这个代码思路是对的，但测试数据有些不能通过*/
public class day7_ThreePointOnLine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double[][] p = new double[n][2];
		for(int i = 0; i < n; i++) {
			p[i][0] = scan.nextDouble();
			p[i][1] = scan.nextDouble();
		}
		//Set set = new HashSet();
		double[] d ;
		Map<Double,Integer> map;
		int nums = 0;
		for(int i = 0; i < n-1; i++) {
			d = K(i , n , p);
			map = S(i, n, d);
			nums += N(map);
		}
		System.out.println(nums);
		scan.close();
		
	}
	public static double[] K(int i , int n, double[][] p) {
		double[] d = new double[n-1-i];
		int t = 0;
		for(int j = i+1; j < n; j++) {
			d[t] = (p[i][1] - p[j][1])/(p[i][0] - p[j][0]) ;
			t++;
		}
		return d;
	}
	public static Map S(int i, int n, double[] d) {
		Map<Double,Integer> map = new HashMap<>();
		
		//int[] z = new int[n-1-i];
		//int t = 0;
		Set set = new HashSet();
		for(int j = 0; j < (n-1-i); j++) {
			if(set.add(d[j]) == false) {
				if(map.get(d[j]) == null) {
					map.put(d[j], 2);
				}else {
					int q = (int) map.get(d[j]);
					map.remove(d[j]);
					map.put(d[j], q+1);
				}
			}
		}
		return map;
	}
	public static int N(Map<Double,Integer> map) {
		int num = 0;
		for(int b : map.values()) {
			//(n-1)...0 -> (n-1 + 0)*n/2
			num += (b-1)*b/2;
		}
		return num;
	}
}

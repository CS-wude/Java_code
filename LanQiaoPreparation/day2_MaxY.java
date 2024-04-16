package one_month;

import java.util.Scanner;
import java.lang.Math;

/*
 * 总结：
 * 出现了一个很严重的问题：段错误
 * 一开始我考虑数组越界，但我一直改就是没发现毛病
 * 后来我想到了输入的数组并非int型，改了这个问题，运行正确
 * 那么说段错误还有情况就是类型不对？还是一串字符串长度大于int导致的移除？
 * 期间我学会了如何int强转char
 * (char)scan.nextInt(),但没试过字符输入后强转会不会出问题，但从8字节转小字节方面我认为值得一试
 * 还有一个方法没有试过：scan.next().charAt(0),应该只适合单个字符*/
public class day2_MaxY {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		 int n = scan.nextInt();
		 int m = scan.nextInt(); 
		 char[][] arr = new char[n][m];
		 for(int i = 0; i < n; i++) {
			 String str = scan.next();
			 for(int j = 0 ;j < m; j++) {
				 arr[i][j] = str.charAt(j);
				 } 
			 }
		 
		int num = 0;
		//假如能实现从中心向外围走，然后判断最大y的长度和距离边的距离，可以达到不用遍历全部元素的效果
		for(int i = 1; i < n-1; i++) {
			for(int j = 1; j < m-1; j++) {
				//这里卡住了，因为arr[n][m]数组不能赋值进方法中，后来理解到输入的是arr
				num = Math.max(num, YorNot(n, m, arr, i, j));
			}
		}
		System.out.println(num);
		
		scan.close();
	}
	public static int YorNot(int n , int m ,char[][] arr, int i, int j) {
		int num = 1;
		while(bianjie(n, m, i, j, num)) {
			if(arr[i][j] == arr[i-num][j-num] && arr[i][j]==arr[i-num][j+num] &&arr[i][j]==arr[i+num][j]) {
				num++;
			} else break;
		}
		return num-1;
	}
	
	public static boolean bianjie(int n, int m , int i, int j, int t) {
		if(i - t >= 0 && i + t < n && j - t >= 0 && j + t < m) return true;
		return false;
	}
}

package one_month;

import java.util.Scanner;
import java.math.BigInteger;

/*
 * 总结：越界是scan.next导致的，他到空格就会停下来
 * 所以需要使用nextLine读一行
 * 还有一个就是可以使用两个字符串进行next
 * 输入就用空格隔开，他们各会得到一个输入,后来这样用感觉又不对？
 * 我发现是那个代码其他的问题，应该不是这个问题*/
public class day9_OldDoor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//String str = scan.nextLine();
		String str = scan.next();
		//System.out.println(str);
		String str2 = scan.next();
		//为什么会越界?
		String[] Str = str.split(" ");
		String[] Str2 = str2.split(" ");
		
		
		//String[] Str2 = str2.split(" ");
		//System.out.println(Str[0] +" "+Str[1]+" "+Str[2]+" "+Str2[0]);
		System.out.println(Str[0] +" "+Str2[0]);
		
		//这是数学=-=
		
		
	}
}

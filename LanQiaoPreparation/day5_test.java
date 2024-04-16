package one_month;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 代码不正确，但这里总结一下
 * 总结：
 * 有时候代码不能run，运行只会说run configurations
 * 不妨新建一个，复制代码过去调试看哪个代码有问题
 * 有时候就算调试对了，原代码位置也不能运行，这时候就在新建位置运行就行
 * 
 * List<String> str1 = new ArrayList<String>(num); 
 * 这里只说了建立num个空间，但里面内容是空的
 * 所以不能用get()不然会发生
 * IndexOutOfBoundsException - 如果索引超出范围 (index < 0 || index >= size())

 * */
public class day5_test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//int num = scan.nextInt();
		//int num = 3;
		//String str = scan.next();
		//String str = "asadadad";
		int num = scan.nextInt();
		String str = scan.next();
		List<String> str1 = new ArrayList<String>(num); 
		for(int i = 0; i < num; i++) {
			str1.add(i, "");
		}
		int len = str.length();
		int lendd = 0;
		for(int i = 0;lendd < len;) {

			String s1 = "";
			s1 += str.charAt(lendd);
			s1 = str1.get(i)+s1;
			str1.add(i, s1);
			i++;
			lendd++;
			
			  if(i == num) {
				  i -= 2;
				  while(i != 0 && lendd < len) {
					  String s2 = "";
					  s2 += str.charAt(lendd); 
					  str1.add(i, str1.get(i)+s2); 
					  i--; lendd++; 
					  } 
				  }
			 
		}
		String str2 = "";
		
		  for(int i = 0; i < num; i++) {
			  str2 += str1.get(i); 
			  }
		 
		System.out.println(str2);
		scan.close();
		System.out.println("test");
	}
}

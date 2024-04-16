package one_month;

//Scanner包
import java.util.Scanner;

public class day1_NumOf13579 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//next()获得字符串
       // String str = scan.next();
		String str = "111222333111222333111222333";
        
        int len = str.length();
        //indexOf获得指定字符所在的索引,如果是-1则为无此字符
		/*
		 * 也有一种情况，indexOf这个方法本就是基于便利，那我自己建立遍历应该更好一点
		 * int t = str.indexOf('1'); while(t != -1) {
		 * 
		 * }
		 */
        int num = 0;
        for(int i = 0; i < len; i++) {
        	//获得索引处的元素
        	//这里还发现一个特别的地方，本来返回的是char，但是我使用int依旧可行，而且速度更快
        	char k = str.charAt(i);
			
			  if(k == '1' || k == '3' || k == '5' || k == '7' || k == '9') { num++; }
			 
        	
        	//改进：使用char转int然后判奇偶
			/*
			 * 改进失败，这个结果有问题，应该是getType的问题
			 * int z = Character.getType(k); if(z % 2 == 1) { num++; }
			 */
        	
        }
        
        System.out.println(num);
        
        //关闭scan
        //scan.close();
        
	}
}

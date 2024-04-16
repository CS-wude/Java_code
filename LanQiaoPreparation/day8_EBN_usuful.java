package one_month;
import java.util.*;
public class day8_EBN_usuful {

	
	// 1:无需package
	// 2: 类名必须Main, 不可修改

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        //在此输入您的代码...
	        for(int i=123;i<987;i++){
	            for(int j=i+1;j<987;j++){
	               if(gcd(j,i)==16){
	                    for(int k=j+1;k<987;k++){
	                        if(gcd(k,j)==16&&gcd(k,i)==16&&check(i,j,k)){
	                                System.out.println(1000000*i+1000*j+k);
	                                break;
	                        }
	                }
	               }
	            }
	        }
	        scan.close();
	    }
	    //gcd最大公约数方法
	    public static  int  gcd(int a,int b){
	       while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }
	        return a;
	    }

	    //这里String转字符数组再排序再转String再判断相等很巧妙
	    public static boolean check(int a,int b ,int c){
	            String s= a+""+b+""+c;
	           char [] c1=  s.toCharArray();
	             Arrays.sort(c1);
	               String sortedStr = new String(c1); 
	           return     sortedStr.equals("123456789");
	    }
	
}

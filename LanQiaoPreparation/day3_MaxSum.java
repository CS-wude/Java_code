package one_month;

import java.util.Scanner;
import java.math.BigInteger;

/*
 * 首次尝试：越界：20
 * 改的过程中发现好像是索引越界，不是int越界，但这么大的数int应该也会越界，BigInteger改的也没毛病
 * 第二次尝试：结果0
 * 使用参数problem测试，是five方法的问题
 * 谜题破晓了，是add()这个方法的问题，BigInteger是用a.add(b)来计算加法
 * 但结果不会直接到a，他会有返回值，所以我们需要用a=来接收,这个问题也是我用惯了自定义方法才疏忽的*/

public class day3_MaxSum {
	static int problem1 = 2;
	static String problem2 = "";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[30][20];
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 20; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		BigInteger m = new BigInteger("0");
		for(int i = 0; i < 25; i++) {
			for(int j = 0; j < 15; j++) {
				m = m.max(Five(arr, i, j));
			}
		}
		
		System.out.println(m);
		scan.close();
	}
	/*
	 * public static int MaxIs(int a, int b) { if(a >= b) return a; else return b; }
	 */
	
	public static BigInteger Five(int[][] arr, int i, int j) {
		BigInteger five = new BigInteger("0");
		for(int x = 0; x < 5; x++) {
			for(int y = 0; y < 5; y++) {
				String str = String.valueOf(arr[i+x][j+y]) ;
				/*
				 * problem2 = str; 
				 * while(problem1 == 2) { 
				 * //字符串正确,是five.add(newBigInteger(str));的问题
				 *  System.out.println(problem2); 
				 *  problem1--; }
				 */
				
				//five.add(new BigInteger(str));
				five = five.add(new BigInteger(str));
				/*
				 * while(problem1 == 1) { 
				 * //输出0，未加进去 
				 * System.out.println(five); 
				 * problem1--; 
				 * }
				 */
				
			}
		}
		/*早想直接用循环替代掉这个，只是觉得直接用索引能提高速度才没换
		 * int five = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j] + arr[i+4][j]
		 * + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i+3][j+1] + arr[i+4][j+1]
		 * + arr[i][j+2] + arr[i+1][j+2] + arr[i+2][j+2] + arr[i+3][j+2] + arr[i+4][j+2]
		 * + arr[i][j+3] + arr[i+1][j+3] + arr[i+2][j+3] + arr[i+3][j+3] + arr[i+4][j+3]
		 * + arr[i][j+4] + arr[i+1][j+4] + arr[i+2][j+4] + arr[i+3][j+4] +
		 * arr[i+4][j+4];
		 */
		return five;
	}
}

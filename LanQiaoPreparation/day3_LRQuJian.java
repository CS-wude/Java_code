package one_month;

/*
 * 总结
 * 运算的顺序很重要
 * 浮点数的使用也要用到位
 * java的输出很强大
 * add:一个知识点，算法题提交算法的时候，数值一般是int
 * 如果你输出的是double类型，他会输出4186.0，而不是结果4186
 * 这会造成不通过答案*/
public class day3_LRQuJian {
	public static void main(String[] args) {
		//这里91和90会直接加起来算和
		System.out.println(91+90+"。。。"+1);
		int num = (1 + 91) * 91 / 2;
		int a =   91 / 2 ;
		a *= (1 + 91);
		
		/*我发现了一个知识点，就算赋值了double，91/2的运算也是先到int再转double*/
		double b = 91 / 2 ;
		b *= (1 + 91);
		
		double c = 91;
		c /= 2;
		c *= (1 + 91);
		 
		System.out.println(num + "," + a + "," + b + "," + c);
		
		/*结果：
		 * 181。。。1
			4186,4140,4140.0,4186.0
			
			神奇的数字*/
	}
}

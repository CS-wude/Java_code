package work.class1;

/**
 * @BelongsProject: IdeaProject
 * @BelongsPackage: work.class1
 * @FileName: Demo
 * @Author: wude
 * @Date: 2023/4/17-23:28
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        //字符串
        //创建空白字符串对象
        String str1 = new String();
        //字符串内容为""
        System.out.println("=" + str1 + "=");

        //根据字符数组内容创建字符串对象
        char[] chs = {'a' , 'b' , 'c' , 'd'};
        String str2 = new String(chs);
        System.out.println(str2);

        //指定字符数组范围创建字符串对象
        String str3 = new String(chs , 0 , 3); //"abc"
        System.out.println(str3);

        //根据字节数组内容创建字符串对象
        byte[] bys = {97 , 98 , 99 , 100 , 101 , 102};
        String str4 = new String(bys); // "abcdef"
        System.out.println(str4);

        //指定字节数组范围
        String str5 = new String(bys , 2 , 3); //cde
        System.out.println(str5);

        //直接赋值方式创建字符串对象
        String str6 = "abc";
        System.out.println(str6);

        /*
        *知识点：通过new创建的字符串对象，每一次都会申请一个内存空间
        *直接赋值方式创建都是指向字符串池中维护的同一个对象
        **/
        char[] chs1 = {'a' , 'b' , 'c'};
        String s1 = new String(chs);
        String s2 = new String(chs);
        System.out.println(s1 == s2); //false

        String s3 = "abc";
        String s4 = "abc";
        System.out.println(s3 == s4);//true


        //String类的特点
        //String类的值在创建后不能修改
        String ss1 = "abc";
        ss1 += "d";
        System.out.println(ss1); //"abcd"
        //内存中有"abc" "abcd" 只是改变了指向
        //每一次拼接String类的字符串对象,都会创建一个新的字符串对象

        //虽然String的值不可变，但是他们可以共享
        /*String s3 = "abc";
        String s4 = "abc";*/

        //String底层是靠字符数组实现的
        String ss2 = "abc";
        //相当于
        char[] ss3 = {'a' , 'b' , 'c'};
        String sss3 = new String(ss3);
        //jdk9底层是字节数组
        byte[] ss4 = {97 , 98 , 99};
        String sss4 = new String(ss4);

        //知识点：字符串的比较
        //==的比较
        //比较基本数据类型比较的是具体的值
        int num1 = 10;
        int num2 = 20;
        //num1 == num2 ===> 10==20 结果:false
        //比较引用数据类型比较的是对象地址值
        String st1 = new String("abc");
        String st2 = new String("abc");
        //st1 == st2 ===> st1存储的对象地址值 == st2存储的对象地址值 结果: false

        //equals方法 比较内容相同，区分大小写
        System.out.println(st1.equals(st2));
        String st3 = "abc";
        System.out.println(st1.equals(st3));

        //equalsIgnoreCase方法 比较内容，忽略大小写
        String st4 = "hello";
        String st5 = "Hello";
        boolean res1 = st4.equalsIgnoreCase(st5);
        System.out.println(res1); //true

        //拓展方法
        //创建字符串对象
        String str = "hello-world";

        //获取长度
        int len = str.length();

        //字符串末尾拼接上hello_it
        String newstr = str.concat("hello_it");

        //获取索引1的字符
        char ch = str.charAt(1);
        //思考：因为是数组

        // 创建字符串对象
        String st = "hello-world-hello-itheima-hello-java-hello-itcast";
        //查找hello第一次出现的索引位置
        int index1 = st.indexOf("hello"); //0
        //hello第二次出现的索引
        int index2 = st.indexOf("hello" , index1 + 1); //重点index1+1
        //第三次
        int index3 = st.indexOf("hello" , index2 + 1); //重点index2+1
        //最后一次
        int lastIndex1 = st.lastIndexOf("hello");
        //倒数第二次
        int lastIndex2 = st.lastIndexOf("hello" , lastIndex1 - 1);
        //思考：第二次的基础上是第一次索引+1开始
        //倒数第二次的基础上是倒数第一次-1开始

        String stt = "hello-world-hello-itheima";
        //获取world-hello-itheima子字符串
        String subStr1 = stt.substring(6);
        // world-hello-itheima
        //思考：就是从索引6开始获取
        // 获取world-hello子字符串
        String subStr2 = stt.substring(6, 17);
        System.out.println("subStr2:"+subStr2);// world-hello
        //思考：就是6开始，17不取为截止

    }
}

package work.class1;

import java.util.ArrayList;
/**
 * @BelongsProject: IdeaProject
 * @BelongsPackage: work.class1
 * @FileName: ArrayListDemo
 * @Author: wude
 * @Date: 2023/4/18-21:28
 * @Version: 1.0
 * @Description:
 */
public class ArrayListDemo {
    public static void main(String[] args){
        //数组大小固定，集合大小可变
        //ArrayList类底层是大小可变的数组的实现
        //ArrayList()构造一个容量为10的空列表
        /*
        * 强调这里使用泛型限制元素类型需要为包装类
        * 基本数据类型 对应 包装类类型
                            byte Byte
                            short Short
                            int Integer
                            long Long
                            float Float
                            double Double
                            boolean Boolean
                            char Character
          */
        ArrayList<String> lis1 = new ArrayList<>();
        ArrayList<Integer> lis2 = new ArrayList<Integer>();
        ArrayList list6 = new ArrayList();// 存储任意类型的对象

        //添加元素的方法add() ，指定位置add(index , element)
        lis1.add("张三");
        lis1.add("李四");
        System.out.println(lis1);
        //[张三, 李四]
        lis1.add(1 , "王五");
        //index=0时,[王五, 张三, 李四]
        //index=1时,[张三, 王五, 李四]
        //可见这是将元素往后挤
        System.out.println(lis1);

        //思考：能否在index为3还未添加的情况下指定添加index为4的位置
        //lis1.add(4 , "赵六");
        //System.out.println(lis1);
        //IndexOutOfBoundsException: Index: 4, Size: 3
        //报错，索引越界

        //常用方法
        //remove
        //public boolean remove(Object o) 删除指定的元素，返回删除是否成功
        //public E remove(int index) 删除指定索引处的元素，返回被删除的元素
        //这里思考一下，如果元素含有1，那么remove(1)怎么区分索引还是元素
        lis2.add(0);
        lis2.add(2);
        lis2.add(3);
        lis2.add(1);
        System.out.println(lis2.remove(1));
        //2
        System.out.println(lis2);
        //boolean i = lis2.remove(1);
        //异常，并未能找到方法去指定删除指定元素与索引的冲突
        //留意思考
        //思考解决：删除1这个元素,需要传入1的Integer对象
        lis2.remove(new Integer(1));
        System.out.println("删除指定元素1：" + lis2);

        //set(index , element) 修改索引处元素
        lis2.set(0 , 9);
        System.out.println(lis2);

        //get(index) ,返回索引处元素
        System.out.println(lis2.get(0));

        // int size() 返回集合元素个数
        System.out.println(lis2.size());

    }
}


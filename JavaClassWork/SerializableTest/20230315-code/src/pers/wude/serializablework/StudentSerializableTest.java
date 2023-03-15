package pers.wude.serializablework;

import java.io.*;
import java.util.Scanner;

/**
 * @BelongsProject: SerializableTest
 * @BelongsPackage: pers.wude.serializablework
 * @FileName: StudentSerializableTest
 * @Author: wude
 * @Date: 2023/3/15-22:27
 * @Version: 1.0
 * @Description:
 */
public class StudentSerializableTest {

    /*
    * 定义序列化方法
    * */
    public void serializableObjectToFile(String fileName , Student stu) {
        try{
            //创建输出文件对象
            File file = new File(fileName);

            //创建文件输出流对象
            FileOutputStream fos = new FileOutputStream(file);

            //创建对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //输出对象
            oos.writeObject(stu);

            oos.close();
            fos.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    * 定义反序列化的方法
    * */
    public Student deserializableObjectFromFile(String fileName){
        Student stu = null;
        try{

            //使用匿名对象的方法
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

            stu = (Student) in.readObject();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return stu;
    }

    public static void main(String[] args) {

        // 创建StudentSerializableTest实例对象，调用定义的序列化方法
        StudentSerializableTest sst = new StudentSerializableTest();

        // 设置文件存储的绝对地址
        String fileName = "D:\\wwx\\java\\student.dat";

        // 新建student类实例对象
        Student stu = new Student();

        // 进行信息的存入
        Scanner sc = new Scanner(System.in);
        int chengji;

        System.out.println("***************请输入学生信息***************");
        System.out.print("学生学号：");
        stu.setID(sc.nextLong());

        System.out.print("学生姓名：");
        stu.setName(sc.next());

        System.out.print("身份证号：");
        stu.setCardID(sc.next());

        System.out.println("*******请输入成绩*******");
        System.out.print("Java:");
        chengji = sc.nextInt();
        stu.Grade.put("Java" , chengji);

        System.out.print("MySQL:");
        chengji = sc.nextInt();
        stu.Grade.put("MySQL" , chengji);

        System.out.print("Java Web:");
        chengji = sc.nextInt();
        stu.Grade.put("Java Web" , chengji);

        System.out.println("信息已保存成功!");

        // 序列化和反序列化操作
        sst.serializableObjectToFile(fileName , stu);
        Student stus = new Student();
        stus = sst.deserializableObjectFromFile(fileName);

        // 输出反序列化结果
        System.out.println("****************学生信息****************");
        System.out.println("学生学号" + "        " + "学生姓名" + "        " + "身份证号");
        System.out.println(stus.getID() + "      " + stus.getName() + "            " + stus.getCardID());

        System.out.println("************各科成绩************");
        System.out.println("课程" + "        " + "成绩");

        // 采用遍历的方法读取成绩
        float num = 0;
        for (String s : stus.Grade.keySet()){
            chengji = stus.Grade.get(s);
            System.out.println(s + "        " + chengji);
            num += chengji;
        }

        // 求取平均成绩
        num /= stus.Grade.size();
        System.out.println("平均成绩：" + num);

    }
}

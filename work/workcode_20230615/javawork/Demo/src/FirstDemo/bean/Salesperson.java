package FirstDemo.bean;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.bean
 * @FileName: Salesperson
 * @Author: wude
 * @Date: 2023/6/10-22:52
 * @Version: 1.0
 * @Description:
 */
public class Salesperson {

    //设置成员属性

    private int Idcard;
    private String Salespersonname;
    private int Age;
    private String Workertype;

    //自动生成构造方法


    public Salesperson(int idcard, String salespersonname, int age, String workertype) {
        Idcard = idcard;
        Salespersonname = salespersonname;
        Age = age;
        Workertype = workertype;
    }

    public Salesperson() {
    }

    //自动生成get/set方法


    public int getIdcard() {
        return Idcard;
    }

    public void setIdcard(int idcard) {
        Idcard = idcard;
    }

    public String getSalespersonname() {
        return Salespersonname;
    }

    public void setSalespersonname(String salespersonname) {
        Salespersonname = salespersonname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getWorkertype() {
        return Workertype;
    }

    public void setWorkertype(String workertype) {
        Workertype = workertype;
    }
}

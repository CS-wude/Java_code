package FirstDemo.bean;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.bean
 * @FileName: Goods
 * @Author: wude
 * @Date: 2023/6/10-22:50
 * @Version: 1.0
 * @Description:
 */
public class Goods {

    //设置成员属性

    private int Id;
    private String Goodname;
    private int Price;
    private int Number;

    //自动生成构造方法

    public Goods(int id, String goodname, int price, int number) {
        Id = id;
        Goodname = goodname;
        Price = price;
        Number = number;
    }

    public Goods() {
    }

    //自动生成get/set方法


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGoodname() {
        return Goodname;
    }

    public void setGoodname(String goodname) {
        Goodname = goodname;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}

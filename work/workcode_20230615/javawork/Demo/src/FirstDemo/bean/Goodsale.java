package FirstDemo.bean;

import java.lang.String;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.bean
 * @FileName: Goodsale
 * @Author: wude
 * @Date: 2023/6/10-23:20
 * @Version: 1.0
 * @Description:
 */
public class Goodsale {

    //设置成员属性

    private String Id;
    private int Goodid;
    private String Goodname;
    private int Salespersonid;
    private String Salespersonname;
    private int Salenumber;
    private int Money;

    //生成set/get方法

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getGoodid() {
        return Goodid;
    }

    public void setGoodid(int goodid) {
        Goodid = goodid;
    }

    public String getGoodname() {
        return Goodname;
    }

    public void setGoodname(String goodname) {
        Goodname = goodname;
    }

    public String getSalespersonname() {
        return Salespersonname;
    }

    public void setSalespersonname(String salespersonname) {
        Salespersonname = salespersonname;
    }

    public int getSalenumber() {
        return Salenumber;
    }

    public void setSalenumber(int salenumber) {
        Salenumber = salenumber;
    }

    public int getSalespersonid() {
        return Salespersonid;
    }

    public void setSalespersonid(int salespersonid) {
        Salespersonid = salespersonid;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

}

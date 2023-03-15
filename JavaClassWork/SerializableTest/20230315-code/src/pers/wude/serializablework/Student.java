package pers.wude.serializablework;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: SerializableTest
 * @BelongsPackage: pers.wude.serializablework
 * @FileName: Student
 * @Author: wude
 * @Date: 2023/3/15-22:25
 * @Version: 1.0
 * @Description:
 */
public class Student implements Serializable {

    // 设置学生信息属性,并使用transient设置cardID不进行序列化

    private long ID ;
    private String Name;
    private transient String cardID;

    // 使用map存储学生成绩

    Map<String , Integer> Grade = new HashMap<>();

    // 一键生成 set 和 get操作

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }
}

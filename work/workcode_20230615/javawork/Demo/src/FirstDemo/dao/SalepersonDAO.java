package FirstDemo.dao;

import FirstDemo.GUITest.SalespersonView;
import FirstDemo.bean.Salesperson;
import FirstDemo.util.DBManager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.dao
 * @FileName: SalepersonDAO
 * @Author: wude
 * @Date: 2023/6/10-22:54
 * @Version: 1.0
 * @Description:
 */
public class SalepersonDAO {

    //创建添加方法
    public void add(Salesperson goods) {

        //创建DBManager 的实例对象
        DBManager manager = new DBManager();

        //通过DBManager获取连接
        Connection connection = manager.getConn();

        // 创建执行sql语句对象
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String strid = String.valueOf(goods.getIdcard());
        String strgoodname = goods.getSalespersonname();
        String strprice = String.valueOf(goods.getAge());
        String strnumber = goods.getWorkertype();

        String sql = "insert into tb_salesperson(Idcard,Salespersonname,Age,Workertype) values(" + strid + ",'" + strgoodname + "'," + strprice +  ",'" + strnumber + "')";

        //使用命令对象指向sql语句
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 释放资源
        manager.close(connection , statement);
    }

    //创建修改方法
    public void update(Salesperson goods){

        delete(goods.getIdcard());
        add(goods);
    }

    //创建删除方法
    public void delete(int id) {

        //创建DBManager 的实例对象
        DBManager manager = new DBManager();

        //通过DBManager获取连接
        Connection connection = manager.getConn();

        // 创建执行sql语句对象
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //执行sql语句,处理结果
        String strid = String.valueOf(id);

        String sql = "delete from tb_salesperson where Idcard = " + strid;

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 释放资源
        manager.close(connection , statement);
    }

    //创建查询方法
    public List<Salesperson> selectAll()  {

        //创建DBManager 的实例对象
        DBManager manager = new DBManager();

        //通过DBManager获取连接
        Connection connection = manager.getConn();

        // 创建执行sql语句对象
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 执行sql语句,处理结果
        String sql = "select * from tb_salesperson";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 创建ArrayList集合,限制集合元素类型为User
        ArrayList<Salesperson> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                // 创建一个Salesperson对象,用来封装记录的列数据
                Salesperson goods = new Salesperson();

                // 封装数据
                goods.setIdcard(resultSet.getInt("Idcard"));
                goods.setSalespersonname(resultSet.getString("Salespersonname"));
                goods.setAge(resultSet.getInt("Age"));
                goods.setWorkertype(resultSet.getString("Workertype"));

                // 添加对象到集合
                list.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 释放资源
        manager.close(connection, statement);

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public static Salesperson selectByid(int id) {
        //创建DBManager 的实例对象
        DBManager manager = new DBManager();

        //通过DBManager获取连接
        Connection connection = manager.getConn();

        // 创建执行sql语句对象
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String strid = String.valueOf(id);

        // 执行sql语句,处理结果
        String sql = "select * from tb_salesperson where Idcard =" + strid;
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Salesperson goods = new Salesperson();

        // 封装数据
        try {

            goods.setIdcard(resultSet.getInt("Idcard"));

            goods.setSalespersonname(resultSet.getString("Salespersonname"));

            goods.setAge(resultSet.getInt("Age"));

            goods.setWorkertype(resultSet.getString("Workertype"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 释放资源
        manager.close(connection, statement);

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return goods;
    }
}

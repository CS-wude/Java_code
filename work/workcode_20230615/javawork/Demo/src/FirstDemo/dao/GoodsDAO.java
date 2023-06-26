package FirstDemo.dao;

import FirstDemo.util.DBManager;
import FirstDemo.bean.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.dao
 * @FileName: GoodsDAO
 * @Author: wude
 * @Date: 2023/6/10-22:53
 * @Version: 1.0
 * @Description:
 */
public class GoodsDAO {

    //创建添加方法
    public void add(Goods goods) {

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

        String strid = String.valueOf(goods.getId());
        String strgoodname = goods.getGoodname();
        String strprice = String.valueOf(goods.getPrice());
        String strnumber = String.valueOf(goods.getNumber());


        String sql = "insert into tb_goods(Id,Goodname,Price,Number) values(" + strid + ",'" + strgoodname + "'," + strprice +  "," + strnumber + ")";

        //使用命令对象指向sql语句
        try {
            statement.executeUpdate(sql);
        //} catch (Exception e) {
        } catch (SQLException e) {
            //这个异常不能抛出Exception
            e.printStackTrace();
        }

        manager.close(connection , statement);
    }

    //创建修改方法
    public void update(Goods goods){

        delete(goods.getId());
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

        String sql = "delete from tb_goods where id = " + strid;

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 释放资源
        manager.close(connection , statement);
    }

    //创建查询方法
    public List<Goods> selectAll()  {

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
        String sql = "select * from tb_goods";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 创建ArrayList集合,限制集合元素类型为User
        ArrayList<Goods> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                // 创建一个User对象,用来封装记录的列数据
                Goods goods = new Goods();

                // 封装数据
                goods.setId(resultSet.getInt("Id"));
                goods.setGoodname(resultSet.getString("Goodname"));
                goods.setPrice(resultSet.getInt("Price"));
                goods.setNumber(resultSet.getInt("Number"));

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

    public static Goods selectByid(int id) {
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
        String sql = "select * from tb_goods where Id =" + strid;
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Goods goods = new Goods();

        // 封装数据
        try {
            goods.setId(resultSet.getInt("Id"));

            goods.setGoodname(resultSet.getString("Goodname"));

            goods.setPrice(resultSet.getInt("Price"));

            goods.setNumber(resultSet.getInt("Number"));
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

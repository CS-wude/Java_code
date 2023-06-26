package FirstDemo.dao;

import FirstDemo.bean.Goodsale;
import FirstDemo.util.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.dao
 * @FileName: GoodsaleDAO
 * @Author: wude
 * @Date: 2023/6/10-23:21
 * @Version: 1.0
 * @Description:
 */
public class GoodsaleDAO {

        //创建添加方法
        public void add(Goodsale goods) {

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
            //编写sql语句

            String strid = String.valueOf(goods.getId());
            String strgoodid = String.valueOf(goods.getGoodid());
            String strgoodname = goods.getGoodname();
            String strpersonid = String.valueOf(goods.getSalespersonid());
            String strpersonname = goods.getSalespersonname();
            String strnumber = String.valueOf(goods.getSalenumber());
            String strmoney = String.valueOf(goods.getMoney());


            String sql1 = "insert into tb_goodsale(Id,GoodId,Goodname,Salespersonid,Salespersonname,Salenumber,Money) values('" + strid + "',"
                    + strgoodid + ",'" + strgoodname + "'," + strpersonid +  ",'" + strpersonname + "'," + strnumber + "," + strmoney +  ")";

            //增加销售记录，那么货物表中对应货物需要减少
            String sql2 = "UPDATE tb_goods\n" +
                    "SET Number = Number-" +strnumber + "\n" +
                    "WHERE Id=" + strgoodid + ";";

            //使用命令对象指向sql语句
            try {
                statement.executeUpdate(sql1);
                statement.executeUpdate(sql2);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 释放资源
            manager.close(connection , statement);
        }

        //创建修改方法
        public void update(Goodsale goods){

            //修改某个流水记录，将对应流水记录删除再添加新内容，实现更新
            delete(goods.getId());
            add(goods);
        }

    public List<Goodsale> mathselect()  {

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

        // 获取需要的表记录，用到了聚合函数，生成新表再使用Goodsale作为载体接收所需数据
        //实现对数据的统计
        String sql = "SELECT Goodid,Goodname,SUM(Salenumber) 'Salenumber'\n" +
                "FROM tb_goodsale \n" +
                "GROUP BY Goodid ;";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 创建ArrayList集合,限制集合元素类型为User
        ArrayList<Goodsale> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                // 创建一个User对象,用来封装记录的列数据
                Goodsale goods = new Goodsale();

                // 封装数据
                goods.setId(resultSet.getString("Goodname"));
                goods.setGoodid(resultSet.getInt("Goodid"));
                goods.setGoodname(resultSet.getString("Goodname"));
                goods.setSalenumber(resultSet.getInt("Salenumber"));

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

        //创建删除方法
        public void delete(String id) {

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
            //String strid = String.valueOf(id);

            String strnumber = String.valueOf(selectByid(id).getSalenumber());
            String strgoodid = String.valueOf(selectByid(id).getGoodid());

            //删除销售记录的同时需要将原本库存添加回去，实现数据的正确性
            String sql2 = "UPDATE tb_goods\n" +
                    "SET Number = Number+" +strnumber + "\n" +
                    "WHERE Id=" + strgoodid + ";";

            //删除对应数据的sql语句
            String sql1 = "delete from tb_goodsale where Id = '" + id + "'";

            try {
                statement.executeUpdate(sql2);
                statement.executeUpdate(sql1);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 释放资源
            manager.close(connection , statement);
        }

        //创建查询方法
        public List<Goodsale> selectAll()  {

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
            String sql = "select * from tb_goodsale";
            ResultSet resultSet = null;
            try {
                resultSet = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 创建ArrayList集合,限制集合元素类型为Goodsale
            ArrayList<Goodsale> list = new ArrayList<>();

            try {
                while (resultSet.next()) {
                    // 创建一个goodsale对象,用来封装记录的列数据
                    Goodsale goods = new Goodsale();

                    // 封装数据
                    goods.setId(resultSet.getString("Id"));
                    goods.setGoodid(resultSet.getInt("Goodid"));
                    goods.setGoodname(resultSet.getString("Goodname"));
                    goods.setSalespersonid(resultSet.getInt("Salespersonid"));
                    goods.setSalespersonname(resultSet.getString("Salespersonname"));
                    goods.setSalenumber(resultSet.getInt("Salenumber"));
                    goods.setMoney(resultSet.getInt("Money"));

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

        public static Goodsale selectByid(String id) {
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
            String sql = "select * from tb_goodsale where Id ='" + id + "'";
            ResultSet resultSet = null;
            try {
                resultSet = statement.executeQuery(sql);
                resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Goodsale goods = new Goodsale();

            // 封装数据
            try {
                goods.setId(resultSet.getString("Id"));
                goods.setGoodid(resultSet.getInt("Goodid"));
                goods.setGoodname(resultSet.getString("Goodname"));
                goods.setSalespersonid(resultSet.getInt("Salespersonid"));
                goods.setSalespersonname(resultSet.getString("Salespersonname"));
                goods.setSalenumber(resultSet.getInt("Salenumber"));
                goods.setMoney(resultSet.getInt("Money"));
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


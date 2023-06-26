package FirstDemo.dao;

import FirstDemo.util.DBManager;
import FirstDemo.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.dao
 * @FileName: UserDAO
 * @Author: wude
 * @Date: 2023/6/11-11:37
 * @Version: 1.0
 * @Description:
 */
public class UserDAO {

    //选择
    public ArrayList select()  {

        //创建DBManger实例对象
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
        String sql = "select * from tb_user";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 创建ArrayList集合,限制集合元素类型为User
        ArrayList<User> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                // 创建一个User对象,用来封装记录的列数据
                User user = new User();

                // 封装数据
                //user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("PASSWORD"));

                // 添加对象到集合
                list.add(user);
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

    //插入
    public void insert(String sql) {

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

        //使用命令对象指向sql语句
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 释放资源
        manager.close(connection , statement);
    }

    //检查用户名重复
    public boolean check(String username)  {

        ArrayList<User> list = select();

        boolean flag = true;
        //遍历获取的list
        for (User user : list) {
            if (user.getUsername().equals(username)) {
                /*
                * 这里一开始使用==
                * 但我想到学习的时候有说equals更安全，==会有bug
                * 果然现在就出现bug，不过现在就用上了这个方法解决了*/
                flag = false;
                return flag;
            }
        }

        return flag;
    }

    //注册账号
    public void regiser(User user) {

        //这里使用了字符串作为账号密码存储
        //String strusername = String.valueOf(user.getUsername());
        //String strpassword = String.valueOf(user.getPassword());
        String strusername = user.getUsername();
        String strpassword = user.getPassword();

        String sql = "insert into tb_user(username,password) values('" + strusername + "','" + strpassword + "')";

        insert(sql);

    }
    //登录
    public Boolean login(String username, String password) throws Exception{

        ArrayList<User> list = select();

        boolean flag = false;
        //遍历获取的list
        for (User user : list) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}

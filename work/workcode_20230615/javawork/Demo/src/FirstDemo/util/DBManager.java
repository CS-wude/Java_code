package FirstDemo.util;

import java.sql.*;

/**
 * @BelongsProject: IdeaProject
 * @BelongsPackage: com.gnust.www.util
 * @FileName: DBManager
 * @Author: wude
 * @Date: 2023/4/19-16:29
 * @Version: 1.0
 * @Description:
 */

public class DBManager {
    // 驱动名
    //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";//目的地址和端口号
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/goodsale_system";
    private static final String USRENAME = "root";
    private static final String PASSWORD = "family";

    static {
        try {
            // 利用反射机制加载驱动
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            // 建立连接，如果连接失败conn为null
            conn = DriverManager.getConnection(URL, USRENAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn, Statement st) {
        try {
            /*if (rs != null) {
                rs.close();
            }
            这里设置一个对结果删除的考虑
            */
            if (st != null){
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch(Exception e){
        e.printStackTrace();
        }
    }
}


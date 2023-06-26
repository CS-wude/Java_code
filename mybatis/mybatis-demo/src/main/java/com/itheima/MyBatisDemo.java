package com.itheima;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongsProject: mybatis
 * @BelongsPackage: com.itheima
 * @FileName: MyBatisDemo
 * @Author: wude
 * @Date: 2023/6/26-22:03
 * @Version: 1.0
 * @Description:
 */
public class MyBatisDemo {
    public static void main(String[] args) throws IOException{
        //1.加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
        List<User> userslist = sqlSession.selectList("test.selectAll");
        //test.selectAll参考userMapper.xml

        System.out.println(userslist);

        //释放资源
        sqlSession.close();
    }
}

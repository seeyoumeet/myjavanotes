package com.seeyoumeet.study.test;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author : yuc5015
 * @Date : 2021/8/13
 * @Description :
 * @Modified By :
 */
public class DruidTest {
    /*声明Druid连接池的对象*/
    private static DruidDataSource dataSource;
    /*8.X版本连接器写法*/
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    /*数据库地址*/
    static final String DB_URL = "jdbc:mysql://localhost/userinfo?" +
            "useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
    public static void main(String[] args) {

        initDataSource();           // 初始化连接池
        try{                        // 插入一个数据
            String sql = "insert into userinfo (username,password)"+ "values(" +"'"+ "yangyang" +"'"+ "," +"'"+"11111111"+"'"+")";
            Connection connection = getConnect();//在连接池里面获取连接对象
            PreparedStatement ps = connection.prepareStatement(sql);//预编译下SQL语句
            int count = ps.executeUpdate();//提交SQL语句
            System.out.println(count);//打印受影响的行数(不为0说明执行了!)
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    // 初始化连接池
    private static void initDataSource() {
        try {
            dataSource = new DruidDataSource(); // 创建Druid连接池
            dataSource.setDriverClassName(JDBC_DRIVER); // 设置连接池的数据库驱动
            dataSource.setUrl(DB_URL); // 设置数据库的连接地址
            dataSource.setUsername("iot"); // 数据库的用户名
            dataSource.setPassword("11223344."); // 数据库的密码
            dataSource.setInitialSize(1); // 设置连接池的初始大小
            dataSource.setMinIdle(1); // 设置连接池大小的下限
            dataSource.setMaxActive(20); // 设置连接池大小的上限
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    //从连接池里面获取一个连接对象
    public static Connection getConnect() throws Exception{
        Connection con=null;
        try {
            con=dataSource.getConnection();
        } catch (Exception e) {
            throw e;
        }
        return con;
    }
}

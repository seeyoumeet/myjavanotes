package com.seeyoumeet.study.test;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : yuc5015
 * @Date : 2021/8/13
 * @Description :
 * @Modified By :
 */
@Slf4j
public class DruidUtils {
    /*声明Druid连接池的对象*/
    private static DruidDataSource dataSource;
    /*8.X版本连接器写法*/
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    /*数据库地址*/
    static final String DB_URL = "jdbc:mysql://121.36.173.68:3721/farmland?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=GMT%2B8&verifyServerCertificate=false&zeroDateTimeBehavior=convertToNull&rewriteBatchedStatements=true";

    public static void insertSQL(String tablename, Map<String, Object> map) {
        String str = String.join(", ", map.keySet());
//        System.out.println(str);

        Set values = new HashSet();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String value = String.valueOf(entry.getValue());
            values.add(value);
        }

        String str2 = String.join(", ", values);

        try{
            String sql = "use farmland;";
//            sql = "insert into " + tablename + "(" + str + ")"+
//                    "values(" + str2 + ")";

             sql = "insert into " + tablename + "(id, batch_id, batch_info, nf, province_id, province_name) values(" +
                    map.get("id") + "," +
                    map.get("batch_id")  + "," +
                    map.get("batch_info")  + "," +
                    map.get("nf")  + "," +
                    map.get("province_id")  + "," +
                    map.get("province_name") +
                    ")";

            System.out.println(sql);
            System.out.println(map.get("id"));

            Connection connection = getConnection();    // 在连接池里面获取连接对象
            PreparedStatement ps = connection.prepareStatement(sql);//预编译下SQL语句
            int count = ps.executeUpdate();             // 提交SQL语句
            System.out.println(count);                  // 打印受影响的行数(不为0说明执行了!)
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    // 初始化连接池
    private static void initDataSource() {
        try {
            dataSource = new DruidDataSource();             // 创建Druid连接池
            dataSource.setDriverClassName(JDBC_DRIVER);     // 设置连接池的数据库驱动
            dataSource.setUrl(DB_URL);                      // 设置数据库的连接地址
            dataSource.setUsername("root");                 // 数据库的用户名
            dataSource.setPassword("8888888");             // 数据库的密码
            dataSource.setInitialSize(1);                  // 设置连接池的初始大小
            dataSource.setMinIdle(1);                       // 设置连接池大小的下限
            dataSource.setMaxActive(20);                    // 设置连接池大小的上限
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    //从连接池里面获取一个连接对象
    public static Connection getConnection() throws Exception{
        initDataSource();           // 初始化连接池

        Connection con=null;
        try {
            con=dataSource.getConnection();
        } catch (Exception e) {
            throw e;
        }
        return con;
    }
}

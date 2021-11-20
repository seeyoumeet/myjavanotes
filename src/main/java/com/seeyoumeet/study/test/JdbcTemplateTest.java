package com.seeyoumeet.study.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * @Author : yuc5015
 * @Date : 2021/8/13
 * @Description :
 * @Modified By :
 */

public class JdbcTemplateTest {
    /**
     * 使用 execute()方法建表
     */

    /*
     * public static void main(String[] args) { //加载配置文件
     *
     * ApplicationContext applicationContext =new
     * ClassPathXmlApplicationContext("applicationContext.xml");
     *
     * //获取jdbcTemplate实例 JdbcTemplate jdbcTemplate=(JdbcTemplate)
     * applicationContext.getBean("jdbcTemplate");
     *
     * //使用execute()方法执行SQL语句，创建用户账户管理表account
     *
     * jdbcTemplate.execute("create table accoutn("+
     * "id int primary key auto_increment,"+ "usrname varchar(50),"+
     * "balance double)"); System.out.println("账户表创建成功!"); }
     */

    @Test
    public  void mainTest() {
        //加载配置文件

        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取jdbcTemplate实例
        JdbcTemplate jdbcTemplate=(JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        //使用execute()方法执行SQL语句，创建用户账户管理表account

        jdbcTemplate.execute("create table account("+
                "id int primary key auto_increment,"+
                "usrname varchar(50),"+
                "balance double)");
        System.out.println("账户表创建成功!");
    }
}




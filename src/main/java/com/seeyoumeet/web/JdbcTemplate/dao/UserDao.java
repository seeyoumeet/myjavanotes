package com.seeyoumeet.web.JdbcTemplate.dao;

import com.seeyoumeet.web.JdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname UserDao
 * @Description : SpringBoot 中使用 JDBCTemplate测试
 * @Date ：2021-08-24
 * @Created by seeyoumeet
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 保存用户
     * @param user
     */
    public void save(User user) {
        String sql = "insert into user(id, nickname, password, email) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getNickname(), user.getPassword(), user.getEmail());
    }

    /**
     * 删除用户
     * @param id
     */
    public void delete(String id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * 查询全部用户
     * @return
     */
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
    }
}

package com.seeyoumeet.web.JdbcTemplate.service;

import com.seeyoumeet.web.JdbcTemplate.entity.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description ：...
 * @Date ：2021-08-24
 * @Created by seeyoumeet
 */
public interface UserService {
    /**
     * 保存用户
     * @param user
     */
    public void save(User user);

    /**
     * 删除用户
     * @param id
     */
    public void delete(String id);

    /**
     * 查询全部用户
     * @return
     */
    public List<User> findAll();
}

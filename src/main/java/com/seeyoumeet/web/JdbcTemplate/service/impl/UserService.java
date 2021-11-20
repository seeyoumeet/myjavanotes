package com.seeyoumeet.web.JdbcTemplate.service.impl;

import com.seeyoumeet.web.JdbcTemplate.dao.UserDao;
import com.seeyoumeet.web.JdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description ：...
 * @Date ：2021-08-24
 * @Created by seeyoumeet
 */
@Service
public class UserService implements com.seeyoumeet.web.JdbcTemplate.service.UserService {
    @Autowired
    private UserDao userDaoByJdbcTemplate;

    @Override
    public void save(User user) {
        userDaoByJdbcTemplate.save(user);
    }

    @Override
    public void delete(String id) {
        userDaoByJdbcTemplate.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userDaoByJdbcTemplate.findAll();
    }
}

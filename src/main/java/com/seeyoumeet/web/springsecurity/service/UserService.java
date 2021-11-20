package com.seeyoumeet.web.springsecurity.service;

import com.seeyoumeet.web.springsecurity.entity.User;

import java.util.Set;

/**
 * @Classname UserService
 * @Description ：...
 * @Date ：2021-08-25
 * @Created by seeyoumeet
 */
public interface UserService {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String username);

}


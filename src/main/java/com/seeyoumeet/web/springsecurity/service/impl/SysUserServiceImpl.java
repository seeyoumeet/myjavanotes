package seeyoumeet.web.springsecurity.service.impl;//package com.seeyoumeet.web.springsecurity.service.impl;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import com.seeyoumeet.web.springsecurity.entity.User;
//import com.seeyoumeet.web.springsecurity.service.UserService;
//
///**
// * @Classname SysUserServiceImpl
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//
//@Service
//public class SysUserServiceImpl implements UserService {
//
//    @Override
//    public User findByUsername(String username) {
//        User user = new User();
//        user.setId(1L);
//        user.setUsername(username);
//        String password = new BCryptPasswordEncoder().encode("123");
//        user.setPassword(password);
//        return user;
//    }
//
//    @Override
//    public Set<String> findPermissions(String username) {
//        Set<String> permissions = new HashSet<>();
//        permissions.add("sys:user:view");
//        permissions.add("sys:user:add");
//        permissions.add("sys:user:edit");
//        permissions.add("sys:user:delete");
//        return permissions;
//    }
//
//}
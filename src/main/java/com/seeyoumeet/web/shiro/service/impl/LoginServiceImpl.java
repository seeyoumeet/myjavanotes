package seeyoumeet.web.shiro.service.impl;//package com.seeyoumeet.web.shiro.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import com.seeyoumeet.web.shiro.dao.RoleDao;
//import com.seeyoumeet.web.shiro.dao.UserDao;
//import com.seeyoumeet.web.shiro.entity.Permission;
//import com.seeyoumeet.web.shiro.entity.Role;
//import com.seeyoumeet.web.shiro.entity.User;
//import com.seeyoumeet.web.shiro.service.LoginService;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Classname LoginServiceImpl
// * @Description ：...
// * @Date ：2021-08-24
// * @Created by seeyoumeet
// */
//@Service
//@Transactional
//public class LoginServiceImpl implements LoginService {
//
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private RoleDao roleDao;
//
//    //添加用户
//    @Override
//    public User addUser(User user) {
//        userDao.save(user);
//        return user;
//    }
//
//    //添加角色
//    @Override
//    public Role addRole(Role role) {
//        User user = userDao.findByName(role.getUser().getName());
//        role.setUser(user);
//        Permission permission1 = new Permission();
//        permission1.setPermission("create");
//        permission1.setRole(role);
//        Permission permission2 = new Permission();
//        permission2.setPermission("update");
//        permission2.setRole(role);
//        List<Permission> permissions = new ArrayList<Permission>();
//        permissions.add(permission1);
//        permissions.add(permission2);
//        role.setPermissions(permissions);
//        roleDao.save(role);
//        return role;
//    }
//
//    //查询用户通过用户名
//    @Override
//    public User findByName(String name) {
//        return userDao.findByName(name);
//    }
//}

package seeyoumeet.web.SpringJPA.service.impl;//package com.seeyoumeet.web.SpringJPA.service.impl;
//
//import com.seeyoumeet.web.SpringJPA.dao.UserDao;
//import com.seeyoumeet.web.SpringJPA.entity.PageQuery;
//import com.seeyoumeet.web.SpringJPA.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import com.seeyoumeet.web.SpringJPA.service.UserService;
//
//import java.util.List;
//
///**
// * @Classname SysUserServiceImpl
// * @Description ：...
// * @Date ：2021-08-24
// * @Created by seeyoumeet
// */
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public void save(User user) {
//        userDao.save(user);
//    }
//
//    @Override
//    public void delete(String id) {
//        userDao.delete(id);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return userDao.findAll();
//    }
//
//    @Override
//    public Object findPage(PageQuery pageQuery) {
//        return userDao.findAll(PageRequest.of(pageQuery.getPage(), pageQuery.getSize()));
//    }
//}

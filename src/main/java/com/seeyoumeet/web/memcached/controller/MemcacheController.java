package seeyoumeet.web.memcached.controller;//package com.seeyoumeet.web.memcached.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.com.seeyoumeet.web.bind.annotation.GetMapping;
//import org.springframework.com.seeyoumeet.web.bind.annotation.RestController;
//import net.spy.memcached.MemcachedClient;
//import net.spy.memcached.internal.OperationFuture;
//
///**
// * @Classname MemcacheController
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//
//@RestController
//public class MemcacheController {
//
//    @Autowired
//    private MemcachedClient memcachedClient;
//
//    @GetMapping("/memcache")
//    public String memcache() throws InterruptedException {
//        // 放入缓存, 如下参数key为name，值为louis，过期时间为5000，单位为毫秒
//        OperationFuture<Boolean> flag = memcachedClient.set("name", 5000, "louis");
//        // 取出缓存
//        Object value = memcachedClient.get("name");
//        System.out.println(value);
//        // 多线程睡眠5秒,让
//        Thread.sleep(5000);
//        value = memcachedClient.get("name");
//        System.out.println(value);
//        return "success";
//    }
//}
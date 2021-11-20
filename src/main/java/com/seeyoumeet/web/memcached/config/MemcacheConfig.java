package seeyoumeet.web.memcached.config;//package com.seeyoumeet.web.memcached.config;
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import net.spy.memcached.MemcachedClient;
//
///**
// * @Classname MemcacheConfig
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//@Configuration
//public class MemcacheConfig {
//
//    @Value("${memcache.ip}")
//    private String ip;
//
//    @Value("${memcache.port}")
//    private int port;
//
//    @Bean
//    public MemcachedClient getClient() {
//        MemcachedClient memcachedClient = null;
//        try {
//            memcachedClient  = new MemcachedClient(new InetSocketAddress(ip, port));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return memcachedClient;
//    }
//}

package seeyoumeet.eventdeal.springeventlistener.controller;//package com.seeyoumeet.eventdeal.springeventlistener.controller;
//
//import com.seeyoumeet.eventdeal.springeventlistener.event.OrderCreateEvent;
//import com.seeyoumeet.eventdeal.springeventlistener.listener.SendEmailOnOrderCreateListener;
//import org.junit.Test;
//import org.springframework.context.event.ApplicationEventMulticaster;
//import org.springframework.context.event.SimpleApplicationEventMulticaster;
//
///**
// * @Author : yuc5015
// * @Date : 2021/10/29
// * @Description :
// * @Modified By :
// */
//
//public class RegisterController {
//
//    @Test
//    public void TestSpringEvent() {
//        // 创建事件广播器
//        ApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
//
//        // 注册事件监听器
//        applicationEventMulticaster.addApplicationListener(new SendEmailOnOrderCreateListener());
//
//        // 广播事件订单创建事件
//        applicationEventMulticaster.multicastEvent(new OrderCreateEvent(applicationEventMulticaster, 1L));
//    }
//}
package com.seeyoumeet.eventdeal.springpublisherbyanno.listener;

import com.seeyoumeet.eventdeal.springpublisher.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description : 用户注册监听器
 * @Modified By :
 */
@Component
public class UserRegisterListener {

    @Order(1)           // 监听器执行顺序
    @EventListener
    public void sendMail(UserRegisterEvent event) {
        System.out.println(String.format("给用户【%s】发送注册成功邮件!", event.getUserName()));
    }

    @Order(0)
    @EventListener
    public void sendCompon(UserRegisterEvent event) {
        System.out.println(String.format("给用户【%s】发送优惠券!", event.getUserName()));
    }
}

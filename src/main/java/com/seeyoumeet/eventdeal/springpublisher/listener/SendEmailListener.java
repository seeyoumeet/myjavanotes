package com.seeyoumeet.eventdeal.springpublisher.listener;

import com.seeyoumeet.eventdeal.springpublisher.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description : 用户注册成功发送邮件
 * @Modified By :
 */
@Component
public class SendEmailListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println(String.format("给用户【%s】发送注册成功邮件!", event.getUserName()));
    }
}

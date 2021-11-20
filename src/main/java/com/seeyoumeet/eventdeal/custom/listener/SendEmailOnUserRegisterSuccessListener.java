package com.seeyoumeet.eventdeal.custom.listener;

import com.seeyoumeet.eventdeal.custom.event.UserRegisterSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description :
 * @Modified By :
 */

/**
 * 用户注册成功事件监听器->负责给用户发送邮件
 */
@Component
public class SendEmailOnUserRegisterSuccessListener implements EventListener<UserRegisterSuccessEvent> {

    @Override
    public void onEvent(UserRegisterSuccessEvent event) {
        System.out.println(
                String.format("给用户【%s】发送注册成功邮件!", event.getUserName()));
    }
}

package com.seeyoumeet.eventdeal.springpublisherbyanno.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description : 用户注册事件
 * @Modified By :
 */

public class UserRegisterEvent extends ApplicationEvent {
    //用户名
    private String userName;

    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

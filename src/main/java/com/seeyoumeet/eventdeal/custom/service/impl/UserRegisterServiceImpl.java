package com.seeyoumeet.eventdeal.custom.service.impl;

import com.seeyoumeet.eventdeal.custom.event.UserRegisterSuccessEvent;
import com.seeyoumeet.eventdeal.custom.listener.SendEmailOnUserRegisterSuccessListener;
import com.seeyoumeet.eventdeal.custom.multicaster.EventMulticaster;
import com.seeyoumeet.eventdeal.custom.multicaster.SimpleEventMulticaster;
import com.seeyoumeet.eventdeal.custom.service.UserRegisterService;
import org.springframework.stereotype.Service;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description :
 * @Modified By :
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    // 事件发布者
    private EventMulticaster eventMulticaster = null;

    public void setEventMulticaster(EventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }

    @Override
    public void registerUser(String userName) {
        // 用户注册(将用户信息入库等操作)
        System.out.println(String.format("用户【%s】注册成功", userName));

        EventMulticaster simpleEventMulticaster = new SimpleEventMulticaster(new SendEmailOnUserRegisterSuccessListener());
        setEventMulticaster(simpleEventMulticaster);

        if (eventMulticaster != null) {
            // 广播事件
            eventMulticaster.multicastEvent(new UserRegisterSuccessEvent(this, userName));
        }
    }
}

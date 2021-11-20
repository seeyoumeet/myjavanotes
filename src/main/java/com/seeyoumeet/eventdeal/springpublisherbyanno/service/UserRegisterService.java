package com.seeyoumeet.eventdeal.springpublisherbyanno.service;

import com.seeyoumeet.eventdeal.springpublisherbyanno.event.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description : 用户注册服务
 * @Modified By :
 */
@Service
public class UserRegisterService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 负责用户注册及发布事件的功能
     * @param userName 用户名
     */
    public void registerUser(String userName) {
        // 用户注册(将用户信息入库等操作)
        System.out.println(String.format("用户【%s】注册成功", userName));

        // 发布注册成功事件
        this.applicationEventPublisher.publishEvent(new UserRegisterEvent(this, userName));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) { // 注入applicationEventPublisher
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

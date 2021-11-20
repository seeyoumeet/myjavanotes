package com.seeyoumeet.eventdeal.springpublisher.controller;

import com.seeyoumeet.eventdeal.springpublisher.service.UserRegisterService;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description :
 * @Modified By :
 */
public class RegController {

    @Test
    @RequestMapping("/register")
    public void registerUser() {
        UserRegisterService userRegisterService = new UserRegisterService();
        userRegisterService.registerUser("路人甲Java");
    }
}

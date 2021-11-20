package com.seeyoumeet.eventdeal.springpublisherbyanno.controller;

import com.seeyoumeet.eventdeal.springpublisherbyanno.service.UserRegisterService;
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

package com.seeyoumeet.eventdeal.custom.controller;

import com.seeyoumeet.eventdeal.custom.service.UserRegisterService;
import com.seeyoumeet.eventdeal.custom.service.impl.UserRegisterServiceImpl;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : yuc5015
 * @Date : 2021/10/29
 * @Description :
 * @Modified By :
 */
public class RegisterController {

    @Test
    @RequestMapping("/register")
    public void registerUser() {
        UserRegisterService userRegisterService = new UserRegisterServiceImpl();
        userRegisterService.registerUser("路人甲Java");
    }
}

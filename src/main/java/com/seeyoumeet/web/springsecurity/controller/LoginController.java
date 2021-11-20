package seeyoumeet.web.springsecurity.controller;//package com.seeyoumeet.web.springsecurity.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.com.seeyoumeet.web.bind.annotation.PostMapping;
//import org.springframework.com.seeyoumeet.web.bind.annotation.RequestBody;
//import org.springframework.com.seeyoumeet.web.bind.annotation.RestController;
//
///**
// * @Classname LoginController
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//@RestController
//public class LoginController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    /**
//     * 登录接口
//     */
//    @PostMapping(value = "/login")
//    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
//        String username = loginBean.getUsername();
//        String password = loginBean.getPassword();
//
//        // 系统登录认证
//        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
//
//        return HttpResult.ok(token);
//    }
//}

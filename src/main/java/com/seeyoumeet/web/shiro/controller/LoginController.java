package seeyoumeet.web.shiro.controller;//package com.seeyoumeet.web.shiro.controller;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.apache.shiro.authz.annotation.RequiresRoles;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.com.seeyoumeet.web.bind.annotation.GetMapping;
//import org.springframework.com.seeyoumeet.web.bind.annotation.PostMapping;
//import org.springframework.com.seeyoumeet.web.bind.annotation.RequestBody;
//import org.springframework.com.seeyoumeet.web.bind.annotation.RestController;
//import com.seeyoumeet.web.shiro.entity.User;
//
///**
// * @Classname LoginController
// * @Description ：...
// * @Date ：2021-08-24
// * @Created by seeyoumeet
// */
//@RestController
//public class LoginController {
//
//    @Autowired
//    private LoginService loginService;
//
//    /**
//     * POST登录
//     * @param map
//     * @return
//     */
//    @PostMapping(value = "/login")
//    public String login(@RequestBody User user) {
//        // 添加用户认证信息
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPassword());
//        // 进行验证，这里可以捕获异常，然后返回对应信息
//        SecurityUtils.getSubject().login(usernamePasswordToken);
//        return "login ok!";
//    }
//
//    /**
//     * 添加用户
//     * @param user
//     * @return
//     */
//    @PostMapping(value = "/addUser")
//    public String addUser(@RequestBody User user) {
//        user = loginService.addUser(user);
//        return "addUser is ok! \n" + user;
//    }
//
//    /**
//     * 添加角色
//     * @param role
//     * @return
//     */
//    @PostMapping(value = "/addRole")
//    public String addRole(@RequestBody Role role) {
//        role = loginService.addRole(role);
//        return "addRole is ok! \n" + role;
//    }
//
//    /**
//     * 注解的使用
//     * @return
//     */
//    @RequiresRoles("admin")
//    @RequiresPermissions("create")
//    @GetMapping(value = "/create")
//    public String create() {
//        return "Create success!";
//    }
//
//    @GetMapping(value = "/index")
//    public String index() {
//        return "index page!";
//    }
//
//    @GetMapping(value = "/error")
//    public String error() {
//        return "error page!";
//    }
//
//    /**
//     * 退出的时候是get请求，主要是用于退出
//     * @return
//     */
//    @GetMapping(value = "/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping(value = "/logout")
//    public String logout() {
//        return "logout";
//    }
//}

package seeyoumeet.web.springsecurity.controller;//package com.seeyoumeet.web.springsecurity.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.com.seeyoumeet.web.bind.annotation.GetMapping;
//import org.springframework.com.seeyoumeet.web.bind.annotation.RequestMapping;
//import org.springframework.com.seeyoumeet.web.bind.annotation.RestController;
//
///**
// * @Classname UserController
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//@RestController
//@RequestMapping("user")
//public class UserController {
//
//    @PreAuthorize("hasAuthority('sys:user:view')")
//    @GetMapping(value="/findAll")
//    public HttpResult findAll() {
//        return HttpResult.ok("the findAll service is called success.");
//    }
//
//    @PreAuthorize("hasAuthority('sys:user:edit')")
//    @GetMapping(value="/edit")
//    public HttpResult edit() {
//        return HttpResult.ok("the edit service is called success.");
//    }
//
//    @PreAuthorize("hasAuthority('sys:user:delete')")
//    @GetMapping(value="/delete")
//    public HttpResult delete() {
//        return HttpResult.ok("the delete service is called success.");
//    }
//
//}
//

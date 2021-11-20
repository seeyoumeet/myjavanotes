package seeyoumeet.web.springsecurity.provider;//package com.seeyoumeet.web.springsecurity.provider;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * @Classname JwtAuthenticationProvider
// * @Description ：登录身份认证组件
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//public class JwtAuthenticationProvider extends DaoAuthenticationProvider {
//
//    public JwtAuthenticationProvider(UserDetailsService userDetailsService) {
//        setUserDetailsService(userDetailsService);
//        setPasswordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        // 可以在此处覆写整个登录认证逻辑
//        return super.authenticate(authentication);
//    }
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
//            throws AuthenticationException {
//        // 可以在此处覆写密码验证逻辑
//        super.additionalAuthenticationChecks(userDetails, authentication);
//    }
//}
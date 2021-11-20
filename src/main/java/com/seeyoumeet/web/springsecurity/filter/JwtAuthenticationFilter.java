package seeyoumeet.web.springsecurity.filter;//package com.seeyoumeet.web.springsecurity.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.com.seeyoumeet.web.authentication.www.BasicAuthenticationFilter;
//import com.seeyoumeet.web.springsecurity.utils.SecurityUtils;
//
///**
// * @Classname JwtAuthenticationFilter
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
//
//    @Autowired
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        // 获取token, 并检查登录状态
//        SecurityUtils.checkAuthentication(request);
//        chain.doFilter(request, response);
//    }
//}

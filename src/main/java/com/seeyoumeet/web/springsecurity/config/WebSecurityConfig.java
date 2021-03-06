package seeyoumeet.web.springsecurity.config;//package com.seeyoumeet.web.springsecurity.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.com.seeyoumeet.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.com.seeyoumeet.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.com.seeyoumeet.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.com.seeyoumeet.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.com.seeyoumeet.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//
//import com.louis.springboot.demo.security.JwtAuthenticationFilter;
//import com.louis.springboot.demo.security.JwtAuthenticationProvider;
//import com.louis.springboot.demo.security.JwtLoginFilter;
//
///**
// * @Classname WebSecurityConfig
// * @Description ：SpringSecurity核心配置类
// * 1. 访问路径URL的授权策略，如登录、Swagger访问免登录认证等
// * 2. 指定了登录认证流程过滤器 JwtLoginFilter，由它来触发登录认证
// * 3. 指定了自定义身份认证组件 JwtAuthenticationProvider，并注入 UserDetailsService
// * 4. 指定了访问控制过滤器 JwtAuthenticationFilter，在授权时解析令牌和设置登录状态
// * 5. 指定了退出登录处理器，因为是前后端分离，防止内置的登录处理器在后台进行跳转
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 使用自定义登录身份认证组件
//        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                // 跨域预检请求
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                // 登录URL
//                .antMatchers("/login").permitAll()
//                // swagger
//                .antMatchers("/swagger**/**").permitAll()
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("/v2/**").permitAll()
//                // 其他所有请求需要身份认证
//                .anyRequest().authenticated();
//        // 退出登录处理器
//        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
//        // 开启登录认证流程过滤器
//        http.addFilterBefore(new JwtLoginFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
//        // 访问控制时登录状态检查过滤器
//        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//}

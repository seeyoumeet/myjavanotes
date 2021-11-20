package seeyoumeet.web.shiro.config;//package com.seeyoumeet.web.shiro.config;
//
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.com.seeyoumeet.web.ShiroFilterFactoryBean;
//import org.apache.shiro.com.seeyoumeet.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import com.seeyoumeet.web.shiro.realm.MyShiroRealm;
//
///**
// * @Classname ShiroConfig
// * @Description ：Shiro配置类，主要配置路由的访问控制，以及注入自定义的认证器MyShiroRealm
// * @Date ：2021-08-24
// * @Created by seeyoumeet
// */
//
//@Configuration
//public class ShiroConfig {
//
//    // 将自己的验证方式加入容器
//    @Bean
//    public MyShiroRealm myShiroRealm() {
//        MyShiroRealm myShiroRealm = new MyShiroRealm();
//        return myShiroRealm;
//    }
//
//    // 权限管理，配置主要是Realm的管理认证
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
//        return securityManager;
//    }
//
//    // Filter工厂，设置对应的过滤条件和跳转条件
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        Map<String, String> filterMap = new HashMap<String, String>();
//        // 登出
//        filterMap.put("/logout", "logout");
//        // swagger
//        filterMap.put("/swagger**/**", "anon");
//        filterMap.put("/webjars/**", "anon");
//        filterMap.put("/v2/**", "anon");
//        // 对所有用户认证
//        filterMap.put("/**", "authc");
//        // 登录
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        // 首页
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        // 错误页面，认证不通过跳转
//        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
//        return shiroFilterFactoryBean;
//    }
//
//    // 加入注解的使用，不加入这个注解不生效
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//}
//

package seeyoumeet.web.shiro.realm;//package com.seeyoumeet.web.shiro.realm;
//
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @Classname MyShiroRealm
// * @Description ：...
// * @Date ：2021-08-24
// * @Created by seeyoumeet
// */
//public class MyShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private LoginService loginService;
//
//    /**
//     * 实现用户认证，通过服务加载用户信息并构造认证对象返回
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
//            throws AuthenticationException {
//        // 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
//        if (authenticationToken.getPrincipal() == null) {
//            return null;
//        }
//        // 获取用户信息
//        String name = authenticationToken.getPrincipal().toString();
//        User user = loginService.findByName(name);
//        if (user == null) {
//            // 这里返回后会报出对应异常
//            return null;
//        } else {
//            // 这里验证authenticationToken和simpleAuthenticationInfo的信息
//            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name,
//                    user.getPassword().toString(), getName());
//            return simpleAuthenticationInfo;
//        }
//    }
//
//    /**
//     * 实现权限认证，通过服务加载用户角色和权限信息设置进去
//     * @param principalCollection
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        // 获取登录用户名
//        String name = (String) principalCollection.getPrimaryPrincipal();
//        // 查询用户名称
//        User user = loginService.findByName(name);
//        // 添加角色和权限
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for (Role role : user.getRoles()) {
//            // 添加角色
//            simpleAuthorizationInfo.addRole(role.getRoleName());
//            for (Permission permission : role.getPermissions()) {
//                // 添加权限
//                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
//            }
//        }
//        return simpleAuthorizationInfo;
//    }
//
//}

package seeyoumeet.web.springsecurity.entity.details;//package com.seeyoumeet.web.springsecurity.entity.details;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import com.seeyoumeet.web.springsecurity.entity.User;
//
///**
// * @Classname detail
// * @Description ：...
// * @Date ：2021-08-25
// * @Created by seeyoumeet
// */
//public class JwtUserDetails extends User {
//
//    private static final long serialVersionUID = 1L;
//
//    public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        this(username, password, true, true, true, true, authorities);
//    }
//
//    public JwtUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
//                          boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//    }
//
//}

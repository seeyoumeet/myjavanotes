package seeyoumeet.web.shiro.entity;//package com.seeyoumeet.web.shiro.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
///**
// * @Classname Permission
// * @Description ：...
// * @Date ：2021-08-24
// * @Created by seeyoumeet
// */
//@Entity
//public class Permission {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String permission;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Role role;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getPermission() {
//        return permission;
//    }
//
//    public void setPermission(String permission) {
//        this.permission = permission;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//}

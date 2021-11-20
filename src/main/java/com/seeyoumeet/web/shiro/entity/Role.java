package seeyoumeet.web.shiro.entity;//package com.seeyoumeet.web.shiro.entity;
//
//import com.seeyoumeet.web.shiro.entity.User;
//import com.seeyoumeet.web.shiro.entity.Permission;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
///**
// * @Classname Role
// * @Description ：...
// * @Date ：2021-08-24
// * @Created by seeyoumeet
// */
//@Entity
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String roleName;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private User user;
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
//    private List<Permission> permissions;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(List<Permission> permissions) {
//        this.permissions = permissions;
//    }
//}

package seeyoumeet.web.SpringJPA.entity;//package com.seeyoumeet.web.SpringJPA.entity;
//
///**
// * @Classname SysUser
// * @Description ：...
// * @Date ：2021-08-24
// * @Created by seeyoumeet
// */
//import lombok.Data;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Index;
//import javax.persistence.Table;
//
//@Entity    // @Entity: 实体类, 必须加上
//// @Table: 对应数据库中的表, 必须, name=表名, Indexes是声明表里的索引, columnList是索引的列, 同时声明此索引列是否唯一, 默认false
//@Table(name = "sys_user", indexes = {@Index(name = "id", columnList = "id", unique = true), @Index(name = "name", columnList = "name", unique = true)})
//@Data
//public class User {
//
//    @Id // @Id: 指明id列, 必须
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue： 表明是否自动生成, 必须, strategy也是必写, 指明主键生成策略, 默认是Oracle
//    private Long id;
//
//    @Column(name = "name", nullable = false) // @Column： 对应数据库列名,可选, nullable 是否可以为空, 默认true
//    private String name;
//
//    private String password;
//
//    private String email;
//}

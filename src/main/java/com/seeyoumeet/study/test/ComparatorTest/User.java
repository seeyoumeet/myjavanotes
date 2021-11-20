package com.seeyoumeet.study.test.ComparatorTest;

import lombok.Data;

/**
 * @Author : yuc5015
 * @Date : 2021/8/5
 * @Description :
 * @Modified By :
 */
@Data
public class User {
    private int age;
    private String name;

    public User( int age, String name ) {
        this.age = age;
        this.name = name;
    }
}

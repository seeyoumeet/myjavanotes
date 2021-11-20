package com.seeyoumeet.study.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seeyoumeet.entity.View;
import com.seeyoumeet.mapper.ViewMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname ViewMapperPageTest
 * @Description ： 测试使用MyBatisPlus进行分页
 * @Date ：2021-08-07
 * @Created by seeyoumeet
 */
public class ViewMapperPageTest {
    @Autowired
    private ViewMapper viewMapper;

    @Test
    public void selectPage(){
        LambdaQueryWrapper<View> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.like(View::getType_id, "python");

        Page<View> userPage = new Page<>(1 , 2);
//        IPage<View> userIPage = viewMapper.selectPage(userPage, userLambdaQueryWrapper);
//        System.out.println("总页数： "+userIPage.getPages());
//        System.out.println("总记录数： "+userIPage.getTotal());
//
//        userIPage.getRecords().forEach(System.out::println);
    }
}

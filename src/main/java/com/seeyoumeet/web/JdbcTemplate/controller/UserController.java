package com.seeyoumeet.web.JdbcTemplate.controller;

import com.seeyoumeet.web.JdbcTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.seeyoumeet.web.JdbcTemplate.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/save")
    public Object save(@RequestBody User user) {
        userService.save(user);
        return 1;
    }

    @GetMapping(value="/delete")
    public Object delete(@RequestParam("id") String id) {
        User user1 = new User();
        user1.setId(Long.valueOf(327547678));
        user1.setNickname("昵称");
        user1.setPassword("124466");
        user1.setEmail("475969@qq.com");

        userService.delete(id);
        return 1;
    }

    @GetMapping(value="/findAll")
    public Object findAll() {
        return userService.findAll();
    }

}

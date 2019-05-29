package com.imooc.controller;

import com.imooc.dataobject.User;
import com.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public Map<String, Object> test(User user) {
        Map<String, Object> modelMap = new HashMap<>();

        userService.saveUser(user);
        modelMap.put("success", true);
        modelMap.put("msg", "添加成功");

        return modelMap;
    }
}

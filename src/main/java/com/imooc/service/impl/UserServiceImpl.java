package com.imooc.service.impl;

import com.imooc.dao.UserDao;
import com.imooc.dataobject.User;
import com.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findAllById(String id) {
        return userDao.findAllById(id);
    }

    @Override
    public void saveUser(User user) {
       userDao.save(user);
    }
}

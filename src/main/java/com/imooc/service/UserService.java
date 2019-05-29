package com.imooc.service;

import com.imooc.dataobject.User;

public interface UserService {

    User findAllById(String id);

    void saveUser(User user);
}

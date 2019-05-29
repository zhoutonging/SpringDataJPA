package com.imooc.dao;

import com.imooc.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {

    User findAllById(String id);

}

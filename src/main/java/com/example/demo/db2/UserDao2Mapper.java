package com.example.demo.db2;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao2Mapper implements UserDao2 {
    @Autowired
    UserDao2 userDao;

    @Override
    public User getUserById(int uid) {
        User user = userDao.getUserById(uid);
        return user;
    }
}

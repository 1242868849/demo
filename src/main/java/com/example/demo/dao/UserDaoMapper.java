package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoMapper implements UserDao{
    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(int uid) {
        User user = userDao.getUserById(uid);
        return user;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}

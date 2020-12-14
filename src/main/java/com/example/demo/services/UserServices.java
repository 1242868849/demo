package com.example.demo.services;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.UserDaoMapper;
import com.example.demo.db2.UserDao2Mapper;
import com.example.demo.entity.User;
import com.example.demo.redisConfig.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServices {
    @Autowired
    private UserDaoMapper userDaoMapper;

    @Autowired
    private UserDao2Mapper userDao2Mapper;

    @Autowired
    RedisUtils redisUtils;

    /**
     * 根据用户编号查询用户信息
     */
    public User getUserByUid(int uid) {
        User userById = null;
        //先从redis中查询数据
        Object userObject = redisUtils.get(Integer.toString(uid));
        if (userObject != null) {
            System.out.println("redis有值直接返回");
            userById = JSONObject.parseObject(userObject.toString(), User.class);
        } else {
            System.out.println("redis没有值查询数据库");
            //redis里查不到去数据库中查询并缓存到redis
            userById = userDaoMapper.getUserById(uid);
            String userString = JSONObject.toJSONString(userById);
            redisUtils.set(Integer.toString(uid), userString);
        }
        return userById;
    }

    /**
     * 根据用户编号查询用户名
     */
    public  String getUserNameByUid(int uid) {
        String name = null;
        //先从redis中查询数据
        Object userObject = redisUtils.hget(Integer.toString(uid),"name");
        if (userObject != null) {
            System.out.println("redis有值直接返回");
            name = userObject.toString();
        } else {
            System.out.println("redis没有值查询数据库");
            //redis里查不到去数据库中查询并缓存到redis
            User userById = userDaoMapper.getUserById(uid);
            name = userById.getName();
            Map<String ,Object> userMap = new HashMap<>();
            userMap.put("name",userById.getName());
            userMap.put("password",userById.getPassword());
            userMap.put("age",userById.getAge());
            userMap.put("uid",userById.getUid());
            redisUtils.hmset(Integer.toString(uid), userMap);
        }
        return name;
    }


    /**
     * 根据用户编号查询用户信息
     */
    public List<User> getUserById(int uid) {


        List<User> userList =new ArrayList<>();
        User userById = userDaoMapper.getUserById(uid);
        System.out.println(userById.toString());
        User userById1 = userDao2Mapper.getUserById(uid);
        System.out.println(userById1.toString());
        userList.add(userById);
        userList.add(userById1);
        return userList;
    }/**
     * 根据用户编号查询用户信息
     */
    public void creatUser() {
        User user = new User();
        user.setName("ceshi");
        user.setAge("8");
        userDaoMapper.insertUser(user);
        System.out.println(user.getUid());

    }
}

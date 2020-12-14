package com.example.demo.main;

import com.example.demo.dao.UserDaoMapper;
import com.example.demo.entity.User;
import com.example.demo.redisConfig.RedisUtils;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestRedis {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserServices userServices;

    @RequestMapping("/test/redis")
    public User testRedis() {
//        User user = new User();
//        user.setId("1");
//        user.setAge("8");
//        user.setName("xiaoming");
//        user.setPassword("1234");
//       redisUtils.set("www",user);
//
//        User q = (User) redisUtils.get("www");
//        System.out.println(q);

        User userById = userServices.getUserByUid(1);

        return userById;

    }

    @RequestMapping("/test/getUserName")
    public String getUserNameByUid() {
        String userNameByUid = userServices.getUserNameByUid(1);
        return userNameByUid;

    }

    @RequestMapping("/test/getUserByid")
    public List<User>  getUserByid() {
        List<User> userList = userServices.getUserById(1);
    redisUtils.sou();
        return userList;

    }

    @RequestMapping("/test/creatUser")
    public void creatUser() {
        userServices.creatUser();

    }


}

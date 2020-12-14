package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserDao {

    /**
    * 通过用户id查询用户信息
    * */
    @Select("SELECT * FROM  user where  uid = #{uid}")
    @Results({
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR),
            @Result(property = "age", column = "age", jdbcType = JdbcType.INTEGER),
            @Result(property = "uid", column = "uid", jdbcType = JdbcType.INTEGER),
            @Result(property = "date", column = "date", jdbcType = JdbcType.DATETIMEOFFSET)
    })
    public User getUserById(int uid);


    @Insert("insert into user (name, age) values (#{name}, #{age})")
    @Options(useGeneratedKeys=true, keyProperty="uid", keyColumn="uid")
    void insertUser(User user);

}

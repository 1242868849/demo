package com.example.demo.db2;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserDao2 {

    /**
    * 通过用户id查询用户信息
    * */
    @Select("SELECT * FROM  user where  id = #{uid}")
    @Results({
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR),
            @Result(property = "uid", column = "id", jdbcType = JdbcType.INTEGER)
    })
    public User getUserById(int uid);

}

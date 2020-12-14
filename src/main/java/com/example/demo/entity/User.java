package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    String uid ;
    String name;
    String age;
    String password;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Date date;
}

package com.guo.springboot.entity;


import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class User {


    private Integer id;
    private String username;
    private String password;
}

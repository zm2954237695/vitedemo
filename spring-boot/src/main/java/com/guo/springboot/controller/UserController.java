package com.guo.springboot.controller;


import com.guo.springboot.entity.User;
import com.guo.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;1
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.list();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.getById(id);
    }
    @PostMapping
    public boolean save( @RequestBody User user){
        return userService.save(user);
    }

    @PutMapping
    public boolean update(@RequestBody User user){
        return userService.updateById(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }
}

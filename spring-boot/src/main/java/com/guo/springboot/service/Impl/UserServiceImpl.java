package com.guo.springboot.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guo.springboot.entity.User;
import com.guo.springboot.mapper.UserMapper;
import com.guo.springboot.service.IUserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}

package com.xning.demo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xning.demo.entity.User;
import com.xning.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public User get(String id) {
        return mapper.get(id);
    }

    public List<User> findList(User user) {
        return mapper.findList(user);
    }

    public Page<User> findPage(Page<User> page, User user) {
        page = PageHelper.startPage(1,2,"");
        mapper.findList(user);
        return page;
    }

    public void insert(User user) {
        mapper.insert(user);
    }

    public void update(User user) {
        mapper.update(user);
    }

    public void delete(String id) {
        mapper.delete(id);
    }

}

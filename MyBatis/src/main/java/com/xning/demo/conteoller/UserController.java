package com.xning.demo.conteoller;

import com.github.pagehelper.Page;
import com.xning.demo.entity.User;
import com.xning.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "get")
    public User get(String id){
        return service.get(id);
    }

    @RequestMapping(value = "findList")
    public List<User> findList(User user){
        return service.findList(user);
    }

    @RequestMapping(value = "findPage")
    public Page<User> findPage(Page<User> page, User user){
        return service.findPage(page,user);
    }

    @RequestMapping(value = "save")
    public void save(User user) {
        service.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        service.update(user);
    }

    @RequestMapping(value = "delete")
    public void delet(String id) {
        service.delete(id);
    }

}

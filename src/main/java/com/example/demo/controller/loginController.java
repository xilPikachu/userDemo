package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.model.PO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {
    @Autowired
    private UserDao userDao;


    @PostMapping("/register")
    public String loginVefify(User user){

        userDao.addUser(user);
        System.out.println("user = [" + user + "]");
        return "{\"status\":\"ok\"}";
    }

    @GetMapping("/select")
    public User selectUser(String username){
        if (username == null){
            return null;
        }else {
            User user=userDao.getUserByName(username);
            return user;
        }
    }

    @DeleteMapping("/deletes")
    public String deleteUser(String username){
        userDao.deleteUser(username);
        return "{\"status\":\"ok\"}";
    }

    @PostMapping("/update")
    public String updateUser(User user){
        userDao.updateUser(user);
        return "{\"status\":\"ok\"}";
    }
}

package com.DBMSProj.DBMS.controller;

import com.DBMSProj.DBMS.entities.User;
import com.DBMSProj.DBMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public void saveUserData(@RequestBody User user) {
        userService.saveUserData(user);
    }

    @RequestMapping(value = "/userDetails", method = RequestMethod.GET)
    public User getUserDetails(String userName) {
        return userService.getUserDetails(userName);
    }

    @RequestMapping(value = "/score", method = RequestMethod.GET)
    public Integer getUserScore(Integer user_id) {
        return userService.getUserScore(user_id);
    }

}


package com.DBMSProj.DBMS.service;

import com.DBMSProj.DBMS.entities.User;
import com.DBMSProj.DBMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    public void saveUserData(User user) {
        userRepository.saveData(user);
    }
    public User getUserDetails(String userName){
        return userRepository.findUserDetails(userName);
    }

    public Integer getUserScore(Integer user_id) {
        return userRepository.getUserScore(user_id);
    }
}

package com.example.spring_bootsecurity.service;


import com.example.spring_bootsecurity.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void removeUserById(Long id);

    User getUserByUsername(String username);

    User getUserById(Long id);

    List<User> getAllUsers();

}

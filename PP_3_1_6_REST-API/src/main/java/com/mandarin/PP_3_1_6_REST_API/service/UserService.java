package com.mandarin.PP_3_1_6_REST_API.service;

import com.mandarin.PP_3_1_6_REST_API.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> getAll();
    public User getById(long id);
    public void deleteUser(long id);
    public void saveUser(User user);
    public void updateUser(User user);
    public User findByUsername(String username);
}

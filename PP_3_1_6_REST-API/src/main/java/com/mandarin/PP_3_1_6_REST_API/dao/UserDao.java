package com.mandarin.PP_3_1_6_REST_API.dao;

import com.mandarin.PP_3_1_6_REST_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao  {

    public List<User> getAll();
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(long id);
    public User getUser(long id);
    public User findByUsername(String username);
}

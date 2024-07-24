package com.mandarin.PP_3_1_6_REST_API.service;

import com.mandarin.PP_3_1_6_REST_API.dao.UserDao;
import com.mandarin.PP_3_1_6_REST_API.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    private final UserDao userDao;


    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao =  userDao;
    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    public User getById(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    public void saveUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public User findByUsername(String name) {
        return userDao.findByUsername(name);
    }

}

package com.mandarin.PP_3_1_6_REST_API.dao;

import com.mandarin.PP_3_1_6_REST_API.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select distinct a from User a", User.class).getResultList();
    }

    //Добавление user
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    //перезаписать user
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    //Удаление user
    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.createQuery("select distinct a from User a where a.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public User findByUsername(String name) {
        return entityManager.createQuery("select distinct a from User a where a.name = :name", User.class)
                .setParameter("name", name).getSingleResult();
    }
}

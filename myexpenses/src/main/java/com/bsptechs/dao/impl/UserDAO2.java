package com.bsptechs.dao.impl;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import com.bsptechs.dao.inter.IUserDAO;
import com.bsptechs.entities.User;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Primary;

@Repository
@Primary
public class UserDAO2 implements IUserDAO{//extends CrudRepository<User, Long>
//desktop application, multithread

     @PersistenceContext
    private EntityManager em;
     

    @Override
    public int insert(User user) {//Ecemi
        em.persist(user);//insert
        return user.getId();
    }

    @Override
    public boolean update(User user) {
        em.merge(user);//update
        return true;
    }

    @Override
    public boolean delete(int id) {
        User tmp = em.find(User.class, id);
        em.remove(tmp);//update sql delete * from user where id=  29, EclipseLink, Hibernate, JPQL->sql
        return true;
    }

    @Override
    public User find(int id) {//jdbc specification-nin shertlerini odeyen kitabxana
        User user = em.find(User.class, id);
        return user;
    }

    //    public List<User> search(String text) {
//
//    }
//    public List<User> findAll(String name, String surname) {
//
//    }
//
    @Override
    public List<User> selectAll() {
        System.out.println("userdao2 selectall");
        Query user = em.createQuery("select u from User u", User.class);//JPA
        List<User> list = user.getResultList();
        return list;
    }
//

    @Override
    public int logIn(String username, String password) {
//        Query query = em.createQuery("select u from User u where u.username = :username and u.password = :password", User.class);//JPA
        Query query = em.createNativeQuery("select * from user where user.username = ? and user.password = ?", User.class);//JPA

        query.setParameter(1, username);
        query.setParameter(2, password);

        List<User> users = query.getResultList();//
        if (users.size() == 1) {
            return 1;
        } else {
            return -1;
        }
    }
//
//    public int signUp(User user) {//Ecemi
//
//    }
 
}

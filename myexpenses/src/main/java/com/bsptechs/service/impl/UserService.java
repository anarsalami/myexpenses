/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.impl;

import com.bsptechs.dao.impl.UserDAO;
import com.bsptechs.dao.inter.IUserDAO;
import com.bsptechs.entities.User;
import com.bsptechs.service.inter.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sarkhanrasullu
 */
@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    UserDAO userDao;
    
    @Override
    public int insert(User user) {
            return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public User find(int id) {
        return userDao.find(id);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public int logIn(String username, String password) {
        return userDao.logIn(username, password);
    }
    public void foo(){
        System.out.println("test done");
    }
    
}

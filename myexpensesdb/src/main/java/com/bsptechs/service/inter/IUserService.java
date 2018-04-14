/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.inter;

import com.bsptechs.entities.User;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface IUserService {
    
    public int insert(User user);

    public boolean update(User user);

    public boolean delete(int id);

    public User find(int id);

    public List<User> search(String text);
//
//    public List<User> findAll(String name, String surname);
//
    public List<User> selectAll();
//
    public int logIn(String username, String password);
//
//    public int signUp(User user);
}

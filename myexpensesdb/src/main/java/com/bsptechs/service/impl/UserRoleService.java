/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.impl;

import com.bsptechs.dao.impl.UserDAO;
import com.bsptechs.dao.impl.UserRoleDAO;
import com.bsptechs.entities.User;
import com.bsptechs.entities.UserRole;
import com.bsptechs.service.inter.IUserRoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Anar Salami
 */
public class UserRoleService implements IUserRoleService{
     @Autowired
    UserRoleDAO userRole;
    
    @Override
    public int insert(UserRole user) {
            return userRole.insert(user);
    }

    @Override
    public boolean update(UserRole user) {
        return userRole.update(user);
    }

    @Override
    public boolean delete(int id) {
        return userRole.delete(id);
    }

    @Override
    public UserRole find(int id) {
        return userRole.find(id);
    }
    @Override
    public List<UserRole> search(String text){
        return userRole.search(text);
    }
    
    @Override
    public List<UserRole> selectAll() {
        return userRole.selectAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bsptechs.dao.inter.IRoleDAO;
import com.bsptechs.entities.Expense;
import com.bsptechs.entities.Role;
import com.bsptechs.service.inter.IRoleService;

/**
 *
 * @author sarkhanrasullu
 */
@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    IRoleDAO userRoleDao;

     @Override
    public int insert(Role role) {
            return userRoleDao.insert(role);
    }

    @Override
    public boolean update(Role role) {
        return userRoleDao.update(role);
    }

    @Override
    public boolean delete(int id) {
        return userRoleDao.delete(id);
    }

    @Override
    public Role find(int id) {
        return userRoleDao.find(id);
    }
    
    @Override
    public List<Role> selectAll() {
        return userRoleDao.selectAll();
    }

 


}

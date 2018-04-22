/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.impl;

import com.bsptechs.dao.inter.IUserRoleDAO;
import com.bsptechs.entities.UserRole;
import com.bsptechs.service.inter.IUserRoleService;
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
public class UserRoleService implements IUserRoleService {

    @Autowired
    IUserRoleDAO userRoleDao;

    @Override
    public List<UserRole> selectAll() {
        return userRoleDao.selectAll();
    }

 


}

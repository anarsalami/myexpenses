/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.inter;

import com.bsptechs.entities.User;
import com.bsptechs.entities.UserRole;
import java.util.List;

/**
 *
 * @author Anar Salami
 */
public interface IUserRoleService {

    public int insert(UserRole user);

    public boolean update(UserRole user);

    public boolean delete(int id);

    public UserRole find(int id);

    public List<UserRole> search(String text);
//
//    public List<User> findAll(String name, String surname);
//

    public List<UserRole> selectAll();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.dao.impl;

import com.bsptechs.entities.User;
import com.bsptechs.entities.UserRole;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import com.bsptechs.dao.inter.IUserRoleDAO;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.criterion.CriteriaQuery;

/**
 *
 * @author Anar Salami
 */
public class UserRoleDAO implements IUserRoleDAO {

    @PersistenceContext
    private EntityManager em;
    
    

    @Override
    public int insert(UserRole userRole) {//Ecemi
        em.persist(userRole);//insert
        return userRole.getId();
    }

    @Override
    public boolean update(UserRole userRole) {
        em.merge(userRole);//update
        return true;
    }

    @Override
    public boolean delete(int id) {
        UserRole tmp = em.find(UserRole.class, id);
        em.remove(tmp);//update sql delete * from user where id=  29, EclipseLink, Hibernate, JPQL->sql
        return true;
    }

    @Override
    public UserRole find(int id) {//jdbc specification-nin shertlerini odeyen kitabxana
        UserRole userRole = em.find(UserRole.class, id);
        return userRole;
    }

    @Override
    public List<UserRole> search(String text) {
        
        List<UserRole> userRole = em.createQuery("select * from UserRole where name like %"+text+"%").getResultList();
        return userRole;
    }
//    public List<User> findAll(String name, String surname) {
//
//    }
//

    @Override
    public List<UserRole> selectAll() {
        Query userRole = em.createQuery("select u from User u", UserRole.class);//JPA
        List<UserRole> list = userRole.getResultList();
        return list;
    }
//

}

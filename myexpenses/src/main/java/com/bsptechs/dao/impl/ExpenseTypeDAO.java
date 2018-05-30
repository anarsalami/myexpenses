/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.dao.impl;

import com.bsptechs.dao.inter.IExpenseTypeDAO;
import com.bsptechs.entities.ExpenseType;
import com.bsptechs.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Anar Salami
 */
public class ExpenseTypeDAO implements IExpenseTypeDAO{
        @PersistenceContext
    private EntityManager em;
     private Criteria cr;
     

    @Override
    public int insert(ExpenseType type) {//Ecemi
        em.persist(type);//insert
        return type.getId();
    }

    @Override
    public boolean update(ExpenseType type) {
        em.merge(type);//update
        return true;
    }

    @Override
    public boolean delete(int id) {
        ExpenseType tmp = em.find(ExpenseType.class, id);
        em.remove(tmp);//update sql delete * from user where id=  29, EclipseLink, Hibernate, JPQL->sql
        return true;
    }

    @Override
    public ExpenseType find(int id) {//jdbc specification-nin shertlerini odeyen kitabxana
        ExpenseType type = em.find(ExpenseType.class, id);
        return type;
    }
    @Override
        public List<ExpenseType> search(String text) {
            Criterion type = Restrictions.ilike("name", "%text%");
            cr.add(type);
            List<ExpenseType> list = cr.list();
            return list;
    }
//    public List<User> findAll(String name, String surname) {
//
//    }
//
    @Override
    public List<ExpenseType> selectAll() {
        Query type = em.createQuery("select u from User u", ExpenseTypeDAO.class);//JPA
        List<ExpenseType> list = type.getResultList();
        return list;
    }
//


}

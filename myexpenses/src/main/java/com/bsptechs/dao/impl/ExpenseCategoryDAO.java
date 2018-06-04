/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.dao.impl;

import com.bsptechs.dao.inter.IExpenseCategoryDAO;
import com.bsptechs.entities.ExpenseCategory;
import com.bsptechs.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anar Salami
 */
@Repository
public class ExpenseCategoryDAO implements IExpenseCategoryDAO{
        @PersistenceContext
    private EntityManager em;
     private Criteria cr;
     

    @Override
    public int insert(ExpenseCategory category) {//Ecemi
        em.persist(category);//insert
        return category.getId();
    }

    @Override
    public boolean update(ExpenseCategory category) {
        em.merge(category);//update
        return true;
    }

    @Override
    public boolean delete(int id) {
        ExpenseCategory tmp = em.find(ExpenseCategory.class, id);
        em.remove(tmp);//update sql delete * from user where id=  29, EclipseLink, Hibernate, JPQL->sql
        return true;
    }

    @Override
    public ExpenseCategory find(int id) {//jdbc specification-nin shertlerini odeyen kitabxana
        ExpenseCategory category = em.find(ExpenseCategory.class, id);
        return category;
    }
    @Override
        public List<ExpenseCategory> search(String text) {
            Criterion category = Restrictions.ilike("name", "%text%");
            cr.add(category);
            List<ExpenseCategory> list = cr.list();
            return list;
    }
//    public List<User> findAll(String name, String surname) {
//
//    }
//
    @Override
    public List<ExpenseCategory> selectAll() {
        Query category = em.createQuery("select u from ExpenseCategory u", ExpenseCategoryDAO.class);//JPA
        List<ExpenseCategory> list = category.getResultList();
        return list;
    }
//

  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.dao.impl;

import com.bsptechs.dao.inter.IExpenseDAO;
import com.bsptechs.entities.Expense;
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
public class ExpenseDAO implements IExpenseDAO{
        @PersistenceContext
    private EntityManager em;
     private Criteria cr;
     

    @Override
    public int insert(Expense expense) {//Ecemi
        em.persist(expense);//insert
        return expense.getId();
    }

    @Override
    public boolean update(Expense expense) {
        em.merge(expense);//update
        return true;
    }

    @Override
    public boolean delete(int id) {
        Expense tmp = em.find(Expense.class, id);
        em.remove(tmp);//update sql delete * from user where id=  29, EclipseLink, Hibernate, JPQL->sql
        return true;
    }

    @Override
    public Expense find(int id) {//jdbc specification-nin shertlerini odeyen kitabxana
        Expense expense = em.find(Expense.class, id);
        return expense;
    }
    @Override
        public List<Expense> search(String text) {
            Criterion expense = Restrictions.ilike("name", "%text%");
            cr.add(expense);
            List<Expense> list = cr.list();
            return list;
    }
//    public List<User> findAll(String name, String surname) {
//
//    }
//
    @Override
    public List<Expense> selectAll() {
        Query expense = em.createQuery("select u from Expense u", Expense.class);//JPA
        List<Expense> list = expense.getResultList();
        return list;
    }
//

}

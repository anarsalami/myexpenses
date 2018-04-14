/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.impl;

import com.bsptechs.dao.impl.ExpenseCategoryDAO;
import com.bsptechs.dao.impl.UserDAO;
import com.bsptechs.entities.ExpenseCategory;
import com.bsptechs.entities.User;
import com.bsptechs.service.inter.IExpenseCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Anar Salami
 */
public class ExpenseCategoryService implements IExpenseCategoryService{
     @Autowired
    ExpenseCategoryDAO categoryDao;
    
    @Override
    public int insert(ExpenseCategory user) {
            return categoryDao.insert(user);
    }

    @Override
    public boolean update(ExpenseCategory user) {
        return categoryDao.update(user);
    }

    @Override
    public boolean delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public ExpenseCategory find(int id) {
        return categoryDao.find(id);
    }
    @Override
    public List<ExpenseCategory> search(String text){
        return categoryDao.search(text);
    }
    
    @Override
    public List<ExpenseCategory> selectAll() {
        return categoryDao.selectAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.impl;

import com.bsptechs.dao.impl.ExpenseDAO;
import com.bsptechs.dao.impl.UserDAO;
import com.bsptechs.entities.Expense;
import com.bsptechs.entities.User;
import com.bsptechs.service.inter.IExpenseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Anar Salami
 */
public class ExpenseService implements IExpenseService{
     @Autowired
    ExpenseDAO expenseDAO;
    
    @Override
    public int insert(Expense user) {
            return expenseDAO.insert(user);
    }

    @Override
    public boolean update(Expense user) {
        return expenseDAO.update(user);
    }

    @Override
    public boolean delete(int id) {
        return expenseDAO.delete(id);
    }

    @Override
    public Expense find(int id) {
        return expenseDAO.find(id);
    }
    @Override
    public List<Expense> search(String text){
        return expenseDAO.search(text);
    }
    
    @Override
    public List<Expense> selectAll() {
        return expenseDAO.selectAll();
    }
}

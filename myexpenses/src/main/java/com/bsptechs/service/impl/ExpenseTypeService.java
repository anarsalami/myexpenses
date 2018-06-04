/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.impl;

import com.bsptechs.dao.impl.ExpenseTypeDAO;
import com.bsptechs.dao.impl.UserDAO;
import com.bsptechs.entities.ExpenseType;
import com.bsptechs.entities.User;
import com.bsptechs.service.inter.IExpenseTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Anar Salami
 */
@Service
@Transactional
public class ExpenseTypeService implements IExpenseTypeService{
   @Autowired
    ExpenseTypeDAO typeDAO;
    
    @Override
    public int insert(ExpenseType user) {
            return typeDAO.insert(user);
    }

    @Override
    public boolean update(ExpenseType user) {
        return typeDAO.update(user);
    }

    @Override
    public boolean delete(int id) {
        return typeDAO.delete(id);
    }

    @Override
    public ExpenseType find(int id) {
        return typeDAO.find(id);
    }
    @Override
    public List<ExpenseType> search(String text){
        return typeDAO.search(text);
    }
    
    @Override
    public List<ExpenseType> selectAll() {
        return typeDAO.selectAll();
    }  
}

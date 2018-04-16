/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.dao.inter;

import com.bsptechs.entities.ExpenseType;
import com.bsptechs.entities.User;
import java.util.List;

/**
 *
 * @author Anar Salami
 */
public interface IExpenseTypeDAO {

    public int insert(ExpenseType user);

    public boolean update(ExpenseType user);

    public boolean delete(int id);

    public ExpenseType find(int id);

    public List<ExpenseType> search(String text);
//
//    public List<User> findAll(String name, String surname);
//

    public List<ExpenseType> selectAll();
//

 
}

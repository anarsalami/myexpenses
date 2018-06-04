/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.inter;

import com.bsptechs.entities.ExpenseCategory;
import com.bsptechs.entities.User;
import java.util.List;

/**
 *
 * @author Anar Salami
 */

public interface IExpenseCategoryService {

    public int insert(ExpenseCategory category);

    public boolean update(ExpenseCategory category);

    public boolean delete(int id);

    public ExpenseCategory find(int id);

//    public List<ExpenseCategory> search(String text);
//
//    public List<User> findAll(String name, String surname);
//

    public List<ExpenseCategory> selectAll();
}

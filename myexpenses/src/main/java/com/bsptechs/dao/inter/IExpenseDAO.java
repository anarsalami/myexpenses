/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.dao.inter;

import com.bsptechs.entities.Expense;
import com.bsptechs.entities.User;
import java.util.List;

/**
 *
 * @author Anar Salami
 */
public interface IExpenseDAO {

    public int insert(Expense expense);

    public boolean update(Expense expense);

    public boolean delete(int id);

    public Expense find(int id);

    public List<Expense> search(String text);
//
//    public List<User> findAll(String name, String surname);
//

    public List<Expense> selectAll();
//

}

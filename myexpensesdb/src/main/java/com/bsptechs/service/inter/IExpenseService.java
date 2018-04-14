/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.service.inter;

import com.bsptechs.entities.Expense;
import com.bsptechs.entities.User;
import java.util.List;

/**
 *
 * @author Anar Salami
 */
public interface IExpenseService {

    public int insert(Expense user);

    public boolean update(Expense user);

    public boolean delete(int id);

    public Expense find(int id);

    public List<Expense> search(String text);
//
//    public List<User> findAll(String name, String surname);
//

    public List<Expense> selectAll();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.inter.jdbc;

import beans.ExpenseType;
import java.util.List;


public interface ExpenseTypeDAOInter {
    public abstract int insert(ExpenseType type);

    public abstract ExpenseType find(int id);

    public List<ExpenseType> search(String text);

    public abstract boolean delete(int id);

    public abstract boolean update(int id, ExpenseType type);
    
    public abstract List<ExpenseType> selectAll();
}

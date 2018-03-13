/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.inter;

import beans.ExpenseCategory;
import java.util.List;

/**
 *
 * @author nicat
 */
public interface ExpenseCategoryDAOInter {
    
    public abstract int insert(ExpenseCategory category);
    
    
    public abstract ExpenseCategory find(int id);

    public List<ExpenseCategory> search(String text);

    public abstract boolean delete(int id);

    public abstract boolean update(int id, ExpenseCategory cat);
    
    public abstract List<ExpenseCategory> selectAll();
}

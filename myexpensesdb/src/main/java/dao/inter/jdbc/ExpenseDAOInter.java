/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.inter.jdbc;

import beans.Expense;
import java.util.List;

/**
 *
 * @author Kanan
 */
public interface ExpenseDAOInter {

    int addExpense(Expense expense);

    List<Expense> searchExpense(String content);

    boolean deleteExpense(int id);

    boolean editExpense(int id, Expense expense);

    List<Expense> allExpenses();
}

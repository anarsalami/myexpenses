package dao.impl.jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import beans.Expense;
import dao.inter.jdbc.ExpenseDAOInter;
import dbutility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kanan
 */
public class ExpenseDAOImpl extends DBUtility implements ExpenseDAOInter {

    @Override
    public int addExpense(Expense expense) {
        Connection connection = null;
        try {
            connection = connect();

            String sql = "INSERT INTO expense (title, description, cost, type_id, category_id, date) VALUES (?,?,?,?,?, now())";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, expense.getTitle());
            stmt.setString(2, expense.getDescription());
            stmt.setDouble(3, expense.getCost());
            stmt.setInt(4, expense.getTypeId());
            stmt.setInt(5, expense.getCategoryId());

            int result = stmt.executeUpdate();
            if (result > 0) {
                int insertId = getInsertId(stmt);
                return insertId;
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            close(connection);
        }
    }

    public static int getInsertId(PreparedStatement stmt) throws Exception {
        ResultSet generatedKeys = stmt.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            return -1;
        }
    }

    @Override
    public boolean deleteExpense(int id) {
        Connection connection = null;
        try {
            connection = connect();

            String sql = "DELETE FROM expense WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            close(connection);
        }
    }

    @Override
    public boolean editExpense(int id, Expense expense) {
        Connection connection = null;
        try {
            connection = connect();

            String sql = "UPDATE expense SET title = ?, description = ?, cost = ?, type_id = ?, category_id = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, expense.getTitle());
            stmt.setString(2, expense.getDescription());
            stmt.setDouble(3, expense.getCost());
            stmt.setInt(4, expense.getTypeId());
            stmt.setInt(5, expense.getCategoryId());
            stmt.setInt(6, id);

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            close(connection);
        }
    }

    @Override
    public List<Expense> allExpenses() {
        Connection connection = null;
        List<Expense> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "SELECT * FROM expense";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int expenseId = rs.getInt("id");
                String expenseTitle = rs.getString("title");
                String expenseDescription = rs.getString("description");
                double expenseCost = rs.getDouble("cost");
                int expenseTypeId = rs.getInt("type_id");
                int expenseCategoryId = rs.getInt("category_id");
                String expenseDate = rs.getString("date");

                Expense expense = new Expense();
                expense.setId(expenseId);
                expense.setTitle(expenseTitle);
                expense.setDescription(expenseDescription);
                expense.setCost(expenseCost);
                expense.setTypeId(expenseTypeId);
                expense.setCategoryId(expenseCategoryId);
                expense.setDate(expenseDate);

                list.add(expense);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return list;
    }

    @Override
    public List<Expense> searchExpense(String text) {
        Connection connection = null;
        List<Expense> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "SELECT * FROM expense WHERE title LIKE ? OR description LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + text + "%");
            stmt.setString(2, "%" + text + "%");
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int expenseId = rs.getInt("id");
                String expenseTitle = rs.getString("title");
                String expenseDescription = rs.getString("description");
                double expenseCost = rs.getDouble("cost");
                int expenseTypeId = rs.getInt("type_id");
                int expenseCategoryId = rs.getInt("category_id");
                String expenseDate = rs.getString("date");

                Expense expense = new Expense();
                expense.setId(expenseId);
                expense.setTitle(expenseTitle);
                expense.setDescription(expenseDescription);
                expense.setCost(expenseCost);
                expense.setTypeId(expenseTypeId);
                expense.setCategoryId(expenseCategoryId);
                expense.setDate(expenseDate);

                list.add(expense);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return list;
    }
}

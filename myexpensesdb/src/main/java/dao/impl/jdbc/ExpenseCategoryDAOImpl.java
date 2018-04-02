package dao.impl.jdbc;



import dao.inter.jdbc.ExpenseCategoryDAOInter;
import beans.ExpenseCategory;
import dbutility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicat
 */
public class ExpenseCategoryDAOImpl extends DBUtility implements ExpenseCategoryDAOInter {

    @Override
    public int insert(ExpenseCategory cat) {
        if(cat.getName().trim().equals(""))
            return 0;
        Connection connection = null;
        try{
            connection = connect();
            String sql = "insert into expense_category(name) values(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cat.getName());

            int result = stmt.executeUpdate();
            if(result > 0) {
                int insertedId =  getInsertId(stmt);
                cat.setId(insertedId);
                return insertedId;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }finally {
            close(connection);
        }
        return 0;
    }

    @Override
    public ExpenseCategory find(int id) {
        Connection connection = null;
        ExpenseCategory cat = null;
        try {
            connection = connect();//return new MySQLConnectionClass(); JPA

            String sql = "select * from expense_category where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);//return new MySQLPreparedStatementClass()
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int catId = rs.getInt("id");
                String catName = rs.getString("name");
                

                cat = new ExpenseCategory();
                cat.setId(catId);
                cat.setName(catName);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection);
        }
        return cat;   
    }

    @Override
    public List<ExpenseCategory> search(String text) {
        if(text.trim().equals(""))
            return null;
        Connection connection = null;
        List<ExpenseCategory> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "select * from expense_category where name like ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+text+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int userId = rs.getInt("id");
                String userName = rs.getString("name");
                

                ExpenseCategory cat = new ExpenseCategory();
                cat.setId(userId);
                cat.setName(userName);
                list.add(cat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection);
        }
        return list;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = null;
        try {
            connection = connect();

            String sql = "delete from expense_category where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            close(connection);
        } 
    }

    @Override
    public boolean update(int id, ExpenseCategory cat) {
        if(cat.getName().trim().equals(""))
            return false;
        Connection connection = null;
        try {
            connection = connect();

            String sql = "update expense_category set name = ? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cat.getName());
            stmt.setInt(2, id);

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            close(connection);
        }
    }

    @Override
    public List<ExpenseCategory> selectAll() {
        Connection connection = null;
        List<ExpenseCategory> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "select * from expense_category";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int userId = rs.getInt("id");
                String userName = rs.getString("name");
                

                ExpenseCategory cat = new ExpenseCategory();
                cat.setId(userId);
                cat.setName(userName);
                

                list.add(cat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection);
        }
        return list;   
    }
    
    
    
}

package dao.impl.jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import beans.ExpenseType;
import beans.User;
import dao.inter.jdbc.ExpenseTypeDAOInter;
import dbutility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anar Salami
 */
public class ExpenseTypeDAOImpl extends DBUtility implements ExpenseTypeDAOInter {

    @Override
    public int insert(ExpenseType type) {
       Connection connection = null;
        try {
            connection = connect();

            String sql = "insert into expense_type(name) values(?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, type.getName());
            

            int result = stmt.executeUpdate();
            if(result > 0) {
                int insertedId =  getInsertId(stmt);
                type.setId(insertedId);
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
    public ExpenseType find(int id) {
     Connection connection = null;
        ExpenseType type = null;
        try {
            connection = connect();//return new MySQLConnectionClass(); JPA

            String sql = "select * from expense_type where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);//return new MySQLPreparedStatementClass()
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int typeId = rs.getInt("id");
                String typeName = rs.getString("name");
                

                type = new ExpenseType();
                type.setId(typeId);
                type.setName(typeName);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection);
        }
        return type;    
    }
    @Override
    public int findIdByName(String name) {
     Connection connection = null;
        ExpenseType type = null;
        try {
            connection = connect();//return new MySQLConnectionClass(); JPA

            String sql = "select * from expense_type where name = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);//return new MySQLPreparedStatementClass()
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int typeId = rs.getInt("id");
                String typeName = rs.getString("name");
                

                type = new ExpenseType();
                type.setId(typeId);
                type.setName(typeName);
                
            }
            return type.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection);
        }
        return type.getId();    
    }

    @Override
    public List<ExpenseType> search(String text) {
         Connection connection = null;
        List<ExpenseType> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "select * from expense_type where name like ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+text+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int userId = rs.getInt("id");
                String userName = rs.getString("name");
                

                ExpenseType type = new ExpenseType();
                type.setId(userId);
                type.setName(userName);
                list.add(type);
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

            String sql = "delete from expense_type where id = ?";
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
    public boolean update(int id, ExpenseType type) {
     Connection connection = null;
        try {
            connection = connect();

            String sql = "update expense_type set name = ? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, type.getName());
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
    public List<ExpenseType> selectAll() {
   Connection connection = null;
        List<ExpenseType> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "select * from expense_type";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int userId = rs.getInt("id");
                String userName = rs.getString("name");
                

                ExpenseType type = new ExpenseType();
                type.setId(userId);
                type.setName(userName);
                

                list.add(type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection);
        }
        return list;   
   }
    
}

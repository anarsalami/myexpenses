package dao.impl;

import beans.User;
import dao.inter.UserDAOInter;
import dbutility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Data Access Object
public class UserDAOImpl extends DBUtility implements UserDAOInter {
//desktop application, multithread
    @Override
    public int insert(User user) {//Ecemi
        Connection connection = null;
        try {
            connection = connect();

            String sql = "insert into user(name,surname,username,password,role_id, reg_date) values(?,?,?,?,?,now())";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRoleId());

            int result = stmt.executeUpdate();
            if(result > 0) {
                int insertedId =  getInsertId(stmt);
                user.setId(insertedId);
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
    public List<User> search(String text) {
         Connection connection = null;
        List<User> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "select * from user where name like ? OR surname like ? OR username like ?  ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+text+"%");
            stmt.setString(2, "%"+text+"%");
            stmt.setString(3, "%"+text+"%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int userId = rs.getInt("id");
                String Name = rs.getString("name");
                String surName = rs.getString("surname");
                String userName = rs.getString("username");
                String password = rs.getString("password");
                int roleId = rs.getInt("role_id");

                User type = new User();
                type.setId(userId);
                type.setName(Name);
                type.setSurname(surName);
                type.setUsername(userName);
                type.setPassword(password);
                type.setRoleId(roleId);
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
    public User find(int id) {//jdbc specification-nin shertlerini odeyen kitabxana
        Connection connection = null;
        User user = null;
        try {
            connection = connect();//return new MySQLConnectionClass(); JPA

            String sql = "select * from user where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);//return new MySQLPreparedStatementClass()
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int userId = rs.getInt("id");
                String userName = rs.getString("name");
                String userSurname = rs.getString("surname");

                user = new User();
                user.setId(userId);
                user.setName(userName);
                user.setSurname(userSurname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection);
        }
        return user;
    }

    @Override
    public List<User> findAll(String name, String surname) {
        Connection connection = null;
        List<User> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "select * from user where name = ? and surname = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, surname);


            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int userId = rs.getInt("id");
                String userName = rs.getString("name");
                String userSurname = rs.getString("surname");

                User user = new User();
                user.setId(userId);
                user.setName(userName);
                user.setSurname(userSurname);

                list.add(user);
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

            String sql = "delete from user where id = ?";
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
    public boolean update(int id, User user) {
         Connection connection = null;
        try {
            connection = connect();

            String sql = "update user set name = ?, surname = ?, username =?, password =?, role_id =? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRoleId());
            stmt.setInt(6, id);

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
    public List<User> selectAll() {
        Connection connection = null;
        List<User> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "select * from user";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int userId = rs.getInt("id");
                String userName = rs.getString("name");
                String userSurname = rs.getString("surname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int roleId = rs.getInt("role_id");

                User user = new User();
                user.setId(userId);
                user.setName(userName);
                user.setSurname(userSurname);
                user.setUsername(username);
                user.setPassword(password);
                user.setRoleId(roleId);

                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection);
        }
        return list;
    }
    public static int getInsertId(PreparedStatement stmt) throws Exception{
        ResultSet generatedKeys = stmt.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }else {
            return -1;
        }
    }
@Override
    public int logIn(String username, String password) {
        Connection connection = null;
        User user = new User();
        
        try {
            connection = connect();
            String sql = "SELECT * FROM user WHERE username = ? and password = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setRoleId(rs.getInt(9));
               
            }

            return user.getRoleId();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return user.getRoleId();
    }
    @Override
    public int signUp(User user) {//Ecemi
        Connection connection = null;
        try {
            connection = connect();

            String sql = "insert into user(name,surname,username,password,role_id, reg_date) values(?,?,?,?,?,now())";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, 2);

            int result = stmt.executeUpdate();
            if(result > 0) {
                int insertedId =  getInsertId(stmt);
                user.setId(insertedId);
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
}

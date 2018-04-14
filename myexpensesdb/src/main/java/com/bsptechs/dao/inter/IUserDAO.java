package com.bsptechs.dao.inter;

import com.bsptechs.entities.User;
import java.util.List;

public interface IUserDAO {

    public int insert(User user);

    public boolean update(User user);

    public boolean delete(int id);

    public User find(int id);

    public List<User> search(String text);
//
//    public List<User> findAll(String name, String surname);
//
    public List<User> selectAll();
//
    public int logIn(String username, String password);
//
//    public int signUp(User user);
}

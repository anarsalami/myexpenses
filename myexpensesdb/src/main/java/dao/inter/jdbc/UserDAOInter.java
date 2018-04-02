package dao.inter.jdbc;

import beans.User;
import java.util.List;

public interface UserDAOInter {

    public abstract int insert(User user);

    public abstract User find(int id);

    public abstract List<User> findAll(String name, String surname);

    public abstract boolean delete(int id);

    public abstract boolean update(int id, User user);
    
    public abstract List<User> selectAll();
    
    public abstract int logIn(String username, String password);
    
    public int signUp(User user);
     public List<User> search(String text);
}

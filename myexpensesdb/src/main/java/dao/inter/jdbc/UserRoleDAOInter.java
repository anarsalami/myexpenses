package dao.inter.jdbc;

import beans.User;
import beans.UserRole;
import java.util.List;

public interface UserRoleDAOInter {
 
    public abstract List<UserRole> selectRoles();
    
    public abstract int insertRole(UserRole role);
    
    public abstract boolean deleteRole(int id);
    
    public abstract boolean updateRole (int id, UserRole role);
    
}

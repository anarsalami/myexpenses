package dao.impl.jdbc;



import beans.User;
import dbutility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.UserRole;
import dao.inter.jdbc.UserRoleDAOInter;

//Data Access Object
public class UserRoleDAOImpl extends DBUtility implements UserRoleDAOInter {

    @Override
    public int insertRole(UserRole role) {
        Connection connection = null;
        try {
            connection = connect();

            String sql = "insert into user_role(name) values(?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, role.getName());
            int result = stmt.executeUpdate();
            if (result > 0) {
                int insertedId = getInsertId(stmt);
                role.setId(insertedId);
                return insertedId;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            close(connection);
        }
        return 0;
    }

    @Override
    public boolean deleteRole(int id) {
        Connection connection = null;
        try {
            connection = connect();

            String sql = "delete from user_role where id = ?";
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
    public boolean updateRole(int id, UserRole role) {
        Connection connection = null;
        try {
            connection = connect();

            String sql = "update user_role set name = ? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, role.getName());
            stmt.setInt(2, id);

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
    public List<UserRole> selectRoles() {
        Connection connection = null;
        List<UserRole> list = new ArrayList<>();
        try {
            connection = connect();

            String sql = "select * from user_role";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("id");
                String userName = rs.getString("name");

                UserRole user = new UserRole();
                user.setId(userId);
                user.setName(userName);

                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
        return list;
    }

   

}

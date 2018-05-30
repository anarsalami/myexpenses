package com.bsptechs.dao.inter;

import com.bsptechs.entities.Role;
import java.util.List;

public interface IRoleDAO {

     public int insert(Role role);

    public boolean update(Role role);

    public boolean delete(int id);

    public Role find(int id);
    public List<Role> selectAll();

}

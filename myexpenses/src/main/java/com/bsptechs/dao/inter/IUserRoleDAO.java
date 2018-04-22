package com.bsptechs.dao.inter;

import com.bsptechs.entities.User;
import com.bsptechs.entities.UserRole;
import java.util.List;

public interface IUserRoleDAO {


    public List<UserRole> selectAll();

}

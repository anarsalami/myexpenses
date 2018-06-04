package com.bsptechs.dao.inter;

import com.bsptechs.entities.User;


public interface UserDetailsDao {
  User findUserByUsername(String username);
}

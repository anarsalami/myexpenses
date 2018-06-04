package com.bsptechs.dao.impl;

import org.springframework.stereotype.Repository;
import com.bsptechs.dao.inter.UserDetailsDao;
import com.bsptechs.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao {

   @PersistenceContext
    private EntityManager em;

  @Override
  public User findUserByUsername(String username) {
     Query query = em.createNativeQuery("select * from user where user.username = ? ", User.class);//JPA

        query.setParameter(1, username);

        List<User> users = query.getResultList();//
        if (users.size() == 1) {
            return users.get(0);
        } else {
            return null;
        }
  }
}

package com.bsptechs.dao.impl;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import com.bsptechs.dao.inter.IUserRoleDAO;
import com.bsptechs.entities.User;
import com.bsptechs.entities.UserRole;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRoleDAO implements IUserRoleDAO{//extends CrudRepository<User, Long>
//desktop application, multithread

     @PersistenceContext
    private EntityManager em;
     
  
    @Override
    public List<UserRole> selectAll() {
        Query query = em.createQuery("select u from UserRole u", UserRole.class);//JPA
        List<UserRole> list = query.getResultList();
        return list;
    }
 
}

package com.bsptechs.dao.impl;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.bsptechs.dao.inter.IRoleDAO;
import com.bsptechs.entities.Role;

@Repository
public class RoleDAO implements IRoleDAO{//extends CrudRepository<User, Long>
//desktop application, multithread

     @PersistenceContext
    private EntityManager em;
     
  
    @Override
    public List<Role> selectAll() {
        Query query = em.createQuery("select u from Role u", Role.class);//JPA
        List<Role> list = query.getResultList();
        return list;
    }
 
}

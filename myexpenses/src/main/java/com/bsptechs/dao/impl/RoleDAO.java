//package com.bsptechs.dao.impl;
//
//import javax.persistence.EntityManager;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import com.bsptechs.dao.inter.IRoleDAO;
//import com.bsptechs.entities.Role;
//
//@Repository
//public class RoleDAO implements IRoleDAO{//extends CrudRepository<User, Long>
////desktop application, multithread
//
//     @PersistenceContext
//    private EntityManager em;
//     
//  
//       @Override
//    public int insert(Role expense) {//Ecemi
//        em.persist(expense);//insert
//        return expense.getId();
//    }
//
//    @Override
//    public boolean update(Role role) {
//        em.merge(role);//update
//        return true;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        Role tmp = em.find(Role.class, id);
//        em.remove(tmp);//update sql delete * from user where id=  29, EclipseLink, Hibernate, JPQL->sql
//        return true;
//    }
//
//    @Override
//    public Role find(int id) {//jdbc specification-nin shertlerini odeyen kitabxana
//        Role expense = em.find(Role.class, id);
//        return expense;
//    }
//    @Override
//    public List<Role> selectAll() {
//        Query query = em.createQuery("select u from Role u", Role.class);//JPA
//        List<Role> list = query.getResultList();
//        return list;
//    }
// 
//}

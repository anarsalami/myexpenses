package dao.impl.jpa;

import dao.inter.jpa.JPAUserDAOInter;
import entities.User;
import dbutility.JPAUtility;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

//Data Access Object
public class JPAUserDAOImpl extends JPAUtility implements JPAUserDAOInter {
//desktop application, multithread

    @Override
    public int insert(User user) {//Ecemi
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);//insert
        em.getTransaction().commit();
        em.close();
        return user.getId();
    }

    @Override
    public boolean update(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(user);//update
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User tmp = em.find(User.class, id);
        em.remove(tmp);//update sql delete * from user where id=  29, EclipseLink, Hibernate, JPQL->sql
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public User find(int id) {//jdbc specification-nin shertlerini odeyen kitabxana
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, id);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    //    public List<User> search(String text) {
//
//    }
//    public List<User> findAll(String name, String surname) {
//
//    }
//
    @Override
    public List<User> selectAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Query user = em.createQuery("select u from User u", User.class);//JPA

        List<User> list = user.getResultList();
        em.close();
        return list;
    }
//

    @Override
    public int logIn(String username, String password) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

//        Query query = em.createQuery("select u from User u where u.username = :username and u.password = :password", User.class);//JPA
        Query query = em.createNativeQuery("select * from user where user.username = ? and user.password = ?", User.class);//JPA
        
        query.setParameter(1, username);
        query.setParameter(2, password);
        
        List<User> users = query.getResultList();//
        em.close();
        if (users.size()==1) {
            return 1;
        } else {
            return -1;
        }
    }
//
//    public int signUp(User user) {//Ecemi
//
//    }
}

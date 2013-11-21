package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entities.User;

public class UserDAO {
	
	LocalEntityManagerFactory emf = new LocalEntityManagerFactory();
	
	public void persistUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
 
        em.persist(user);
 
        tx.commit();
        em.close();
    }
 
    @SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
 
        Query allUsersQuery = em.createQuery("select u from User u");
 
		List<User> allUsers = allUsersQuery.getResultList();
 
        tx.commit();
        em.close();
 
        return allUsers;
    }
	
    public String sayPlainTextHello() {
		 return "Hello Jersey";
    }
}

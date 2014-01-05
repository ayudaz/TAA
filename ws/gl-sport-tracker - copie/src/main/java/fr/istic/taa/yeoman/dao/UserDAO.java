package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.yeoman.api.User;

public class UserDAO extends GenericDaoImpl<User, Integer> {
	
	LocalEntityManagerFactory emf = new LocalEntityManagerFactory();
 
    @SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
 
        Query allUsersQuery = em.createQuery("select u from UserImpl u");
 
		List<User> allUsers = allUsersQuery.getResultList();
 
        tx.commit();
        em.close();
 
        return allUsers;
    }
    
}

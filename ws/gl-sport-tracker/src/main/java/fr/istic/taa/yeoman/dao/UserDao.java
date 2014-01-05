package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entities.UserImpl;
import fr.istic.yeoman.api.User;

public class UserDao extends GenericDaoImpl<UserImpl, Integer> {
	
	
    @SuppressWarnings("unchecked")
	public List<User> findAll() {
    	
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query allUsersQuery = entityManager.createQuery("select u from UserImpl u");
 
		List<User> allUsers = allUsersQuery.getResultList();
 
        tx.commit();
        return allUsers;
    }
    
}

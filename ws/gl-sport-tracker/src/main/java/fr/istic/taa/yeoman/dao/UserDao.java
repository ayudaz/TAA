package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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

	public User findByMailPassword(String userMail, String userPassword) {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query UserByMailPasswordQuery = entityManager.createQuery("select u from UserImpl u where mail=:mail and password=:password");
        UserByMailPasswordQuery.setParameter("mail", userMail);
        UserByMailPasswordQuery.setParameter("password", userPassword);
        User user;
        try{
        	user = (User) UserByMailPasswordQuery.getSingleResult();
        }catch(NoResultException e){
        	user = null;
        }
        tx.commit();
        return user;
	}
    
}

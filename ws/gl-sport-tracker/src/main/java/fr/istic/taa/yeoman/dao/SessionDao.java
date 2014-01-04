package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entities.SessionImpl;
import fr.istic.yeoman.api.Session;

public class SessionDao extends GenericDaoImpl<SessionImpl, Integer> {

	@SuppressWarnings("unchecked")
	public List<Session> getSessionsByUser(int userId) {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query sessionsByUserQuery = entityManager.createQuery("select s from SessionImpl s join s.user u where u.id = :userId");
        sessionsByUserQuery.setParameter("userId", userId);
        
		List<Session> allSessionsByUser = sessionsByUserQuery.getResultList();
 
        tx.commit();
        return allSessionsByUser;
	}

}

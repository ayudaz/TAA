package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entities.SessionImpl;
import fr.istic.yeoman.api.Session;

public class SessionDao extends GenericDaoImpl<SessionImpl, Integer> {

	@SuppressWarnings("unchecked")
	public List<Session> getAll() {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query sessionsByUserQuery = entityManager.createQuery("select s from SessionImpl s");
        
		List<Session> allSessionsByUser = sessionsByUserQuery.getResultList();
 
        tx.commit();
        return allSessionsByUser;
	}

}

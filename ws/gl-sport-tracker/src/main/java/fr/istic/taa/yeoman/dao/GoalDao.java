package fr.istic.taa.yeoman.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.yeoman.api.Goal;

public class GoalDao extends GenericDaoImpl<Goal, Integer> {

	@SuppressWarnings("unchecked")
	public Collection<Goal> getAll() {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query GoalQuery = entityManager.createQuery("select s from GoalImpl s");
        
		List<Goal> allGoals = GoalQuery.getResultList();
 
        tx.commit();
        return allGoals;
	}

}

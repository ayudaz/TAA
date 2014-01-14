package fr.istic.taa.yeoman.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.yeoman.api.SportType;

public class SportTypeDao extends GenericDaoImpl<SportType, Integer> {
	
	@SuppressWarnings("unchecked")
	public Collection<SportType> getAll() {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query SportTypeQuery = entityManager.createQuery("select s from SportTypeImpl s");
        
		List<SportType> allSportTypes = SportTypeQuery.getResultList();
 
        tx.commit();
        return allSportTypes;
	}
}

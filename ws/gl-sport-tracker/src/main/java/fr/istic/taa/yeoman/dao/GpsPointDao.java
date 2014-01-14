package fr.istic.taa.yeoman.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.yeoman.api.GpsPoint;

public class GpsPointDao extends GenericDaoImpl<GpsPoint, Integer> {
	
	@SuppressWarnings("unchecked")
	public Collection<GpsPoint> getAll() {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query GpsPointQuery = entityManager.createQuery("select s from GpsPointImpl s");
        
		List<GpsPoint> allGpsPoints = GpsPointQuery.getResultList();
 
        tx.commit();
        return allGpsPoints;
	}
}

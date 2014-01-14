package fr.istic.taa.yeoman.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.yeoman.api.Weather;

public class WeatherDao extends GenericDaoImpl<Weather, Integer> {

	@SuppressWarnings("unchecked")
	public Collection<Weather> getAll() {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query WeatherQuery = entityManager.createQuery("select s from WeatherImpl s");
        
		List<Weather> allWeathers = WeatherQuery.getResultList();
 
        tx.commit();
        return allWeathers;
	}
}

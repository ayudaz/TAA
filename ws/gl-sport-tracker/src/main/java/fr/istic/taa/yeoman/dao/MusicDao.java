package fr.istic.taa.yeoman.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.yeoman.api.Music;

public class MusicDao extends GenericDaoImpl<Music, Integer> {
	
	@SuppressWarnings("unchecked")
	public Collection<Music> getAll() {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query MusicQuery = entityManager.createQuery("select s from MusicImpl s");
        
		List<Music> allMusics = MusicQuery.getResultList();
 
        tx.commit();
        return allMusics;
	}
}

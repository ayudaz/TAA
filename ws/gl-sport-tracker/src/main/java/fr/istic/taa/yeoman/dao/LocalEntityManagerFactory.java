package fr.istic.taa.yeoman.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocalEntityManagerFactory {
	 
    private EntityManagerFactory emf;
    
    public LocalEntityManagerFactory(){
    	emf = Persistence.createEntityManagerFactory("mysql");
    }
 
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
 
    public void closeEntityManager() {
        emf.close();
    }
 
}

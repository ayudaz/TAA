package fr.istic.taa.yeoman;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO {
	 
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
 
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
 
    public static void closeEntityManager() {
        emf.close();
    }
 
}

package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.yeoman.entities.User;

@Path("/users")
public class UserDAO extends GenericDAO {
	
	public void persistUser(User user) {
        EntityManager em = createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
 
        em.persist(user);
 
        tx.commit();
        em.close();
    }
 
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<User> getAllUsers() {
        EntityManager em = createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
 
        Query allUsersQuery = em.createQuery("select u from User u");
 
        List<User> allUsers = allUsersQuery.getResultList();
 
        tx.commit();
        em.close();
 
        return allUsers;
    }
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
		 return "Hello Jersey";
    }
}

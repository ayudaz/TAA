package fr.istic.taa.yeoman.resources;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.yeoman.dao.UserDao;
import fr.istic.taa.yeoman.entities.UserImpl;
import fr.istic.yeoman.api.User;

@Path("/users")
public class UserResource {

	UserDao userDao;
	
	public UserResource(){
		userDao = new UserDao();
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<User> getAll() {
        return userDao.findAll();
    }
	
	@GET @Path("/{userId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public User get(@PathParam("userId") int userId){
		return userDao.read(userId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void add(UserImpl user){
		userDao.create(user);
	}
	
	@PUT @Path("/{userId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void update(UserImpl user){
		userDao.update(user);
	}
	
	@DELETE @Path("/{userId}")
	public void delete(@PathParam("userId")int userId){
		userDao.delete(userId);
	}
	
	@GET @Path("/{userId}/sessions")
	public SessionResource getSessions(@PathParam("userId") int userId){
		return new SessionResource(userId);
	}
	
	@GET @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
}

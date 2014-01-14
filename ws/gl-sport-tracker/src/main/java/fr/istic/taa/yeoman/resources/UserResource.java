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
import fr.istic.taa.yeoman.entities.SessionImpl;
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
	
	@GET @Path("/{userMail}/{userPassword}")
	@Produces({ MediaType.APPLICATION_JSON })
	public User getUserByMailPassword(@PathParam("userMail") String userMail, @PathParam("userPassword") String userPassword){
		return userDao.findByMailPassword(userMail, userPassword);
	}
	
	@GET @Path("/{userId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public User get(@PathParam("userId") int userId){
		return userDao.read(userId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public int add(UserImpl user){
		try{
			User u = userDao.create(user);
			return u.getId();
		}catch(Exception e){
			return -1;
		}
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
	@Produces({ MediaType.APPLICATION_JSON })
	public Collection<SessionImpl> getSessions(@PathParam("userId")int userId){
		return userDao.getSessions(userId);
	}
	
	@GET @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
}

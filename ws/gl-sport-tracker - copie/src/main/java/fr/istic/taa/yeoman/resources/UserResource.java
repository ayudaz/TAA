package fr.istic.taa.yeoman.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.taa.yeoman.dao.UserDAO;
import fr.istic.yeoman.api.User;

@Path("/users")
public class UserResource {

	UserDAO userDao = new UserDAO();
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<User> list() {
        return userDao.getAllUsers();
    }
	
	@GET
	@Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
}

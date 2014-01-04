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

import fr.istic.taa.yeoman.dao.SessionDao;
import fr.istic.taa.yeoman.entities.SessionImpl;
import fr.istic.yeoman.api.Session;

public class SessionResource {
	
	SessionDao sessionDao;
	int userId;
	
	public SessionResource(int userId){
		sessionDao = new SessionDao();
		this.userId = userId;
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Session> getAllByUser() {
        return sessionDao.getSessionsByUser(userId);
    }
	
	@GET @Path("/{sessionId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Session getSession(@PathParam("sessionId")int sessionId){
		return sessionDao.read(sessionId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void newSession(SessionImpl session){
		sessionDao.create(session);
	}
	
	@PUT @Path("/{sessionId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateSession(SessionImpl session){
		sessionDao.update(session);
	}
	
	@DELETE @Path("{sessionId}")
	public void deleteSession(@PathParam("sessionId") int sessionId){
		sessionDao.delete(sessionId);
	}
	

}

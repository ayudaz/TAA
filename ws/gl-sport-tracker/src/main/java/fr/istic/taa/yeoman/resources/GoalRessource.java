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

import fr.istic.taa.yeoman.dao.GoalDao;
import fr.istic.taa.yeoman.entities.GoalImpl;
import fr.istic.yeoman.api.Goal;

@Path("/goals")
public class GoalRessource {

	GoalDao GoalDao;
	
	public GoalRessource(){
		GoalDao = new GoalDao();
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Goal> getAll() {
        return GoalDao.getAll();
    }
	
	@GET @Path("/{GoalId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Goal getGoal(@PathParam("GoalId")int GoalId){
		return GoalDao.read(GoalId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void newGoal(GoalImpl Goal){
		GoalDao.create(Goal);
	}
	
	@PUT @Path("/{GoalId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateGoal(GoalImpl Goal){
		GoalDao.update(Goal);
	}
	
	@DELETE @Path("/{GoalId}")
	public void deleteGoal(@PathParam("GoalId") int GoalId){
		GoalDao.delete(GoalId);
	}
	
}

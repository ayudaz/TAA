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

import fr.istic.taa.yeoman.dao.SportTypeDao;
import fr.istic.taa.yeoman.entities.SportTypeImpl;
import fr.istic.yeoman.api.SportType;

@Path("/sporttypes")
public class SportTypeRessource {
SportTypeDao SportTypeDao;
	
	public SportTypeRessource(){
		SportTypeDao = new SportTypeDao();
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<SportType> getAll() {
        return SportTypeDao.getAll();
    }
	
	@GET @Path("/{SportTypeId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public SportType getSportType(@PathParam("SportTypeId")int SportTypeId){
		return SportTypeDao.read(SportTypeId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void newSportType(SportTypeImpl SportType){
		SportTypeDao.create(SportType);
	}
	
	@PUT @Path("/{SportTypeId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateSportType(SportTypeImpl SportType){
		SportTypeDao.update(SportType);
	}
	
	@DELETE @Path("/{SportTypeId}")
	public void deleteSportType(@PathParam("SportTypeId") int SportTypeId){
		SportTypeDao.delete(SportTypeId);
	}
	
}

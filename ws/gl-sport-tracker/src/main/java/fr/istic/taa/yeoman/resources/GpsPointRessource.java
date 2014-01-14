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

import fr.istic.taa.yeoman.dao.GpsPointDao;
import fr.istic.taa.yeoman.entities.GpsPointImpl;
import fr.istic.yeoman.api.GpsPoint;

@Path("/gpspoints")
public class GpsPointRessource {
GpsPointDao GpsPointDao;
	
	public GpsPointRessource(){
		GpsPointDao = new GpsPointDao();
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<GpsPoint> getAll() {
        return GpsPointDao.getAll();
    }
	
	@GET @Path("/{GpsPointId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public GpsPoint getGpsPoint(@PathParam("GpsPointId")int GpsPointId){
		return GpsPointDao.read(GpsPointId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void newGpsPoint(GpsPointImpl GpsPoint){
		GpsPointDao.create(GpsPoint);
	}
	
	@PUT @Path("/{GpsPointId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateGpsPoint(GpsPointImpl GpsPoint){
		GpsPointDao.update(GpsPoint);
	}
	
	@DELETE @Path("/{GpsPointId}")
	public void deleteGpsPoint(@PathParam("GpsPointId") int GpsPointId){
		GpsPointDao.delete(GpsPointId);
	}
	
}

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

import fr.istic.taa.yeoman.dao.WeatherDao;
import fr.istic.taa.yeoman.entities.WeatherImpl;
import fr.istic.yeoman.api.Weather;

@Path("/weathers")
public class WeatherRessource {
WeatherDao WeatherDao;
	
	public WeatherRessource(){
		WeatherDao = new WeatherDao();
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Weather> getAll() {
        return WeatherDao.getAll();
    }
	
	@GET @Path("/{WeatherId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Weather getWeather(@PathParam("WeatherId")int WeatherId){
		return WeatherDao.read(WeatherId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public int newWeather(WeatherImpl Weather){
		try{
			Weather w = WeatherDao.create(Weather);
			return w.getId();
		}catch(Exception e){
			return -1;
		}
	}
	
	@PUT @Path("/{WeatherId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateWeather(WeatherImpl Weather){
		WeatherDao.update(Weather);
	}
	
	@DELETE @Path("/{WeatherId}")
	public void deleteWeather(@PathParam("WeatherId") int WeatherId){
		WeatherDao.delete(WeatherId);
	}
	
}

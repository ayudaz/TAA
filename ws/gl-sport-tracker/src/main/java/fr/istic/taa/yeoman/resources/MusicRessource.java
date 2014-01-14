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

import fr.istic.taa.yeoman.dao.MusicDao;
import fr.istic.taa.yeoman.entities.MusicImpl;
import fr.istic.yeoman.api.Music;

@Path("/musics")
public class MusicRessource {
MusicDao MusicDao;
	
	public MusicRessource(){
		MusicDao = new MusicDao();
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Music> getAll() {
        return MusicDao.getAll();
    }
	
	@GET @Path("/{MusicId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Music getMusic(@PathParam("MusicId")int MusicId){
		return MusicDao.read(MusicId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void newMusic(MusicImpl Music){
		MusicDao.create(Music);
	}
	
	@PUT @Path("/{MusicId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateMusic(MusicImpl Music){
		MusicDao.update(Music);
	}
	
	@DELETE @Path("/{MusicId}")
	public void deleteMusic(@PathParam("MusicId") int MusicId){
		MusicDao.delete(MusicId);
	}
	
}

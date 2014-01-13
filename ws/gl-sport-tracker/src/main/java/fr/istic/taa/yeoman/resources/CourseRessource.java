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

import fr.istic.taa.yeoman.dao.CourseDao;
import fr.istic.taa.yeoman.dao.SessionDao;
import fr.istic.taa.yeoman.entities.CourseImpl;
import fr.istic.taa.yeoman.entities.SessionImpl;
import fr.istic.yeoman.api.Course;
import fr.istic.yeoman.api.Session;

@Path("/courses")
public class CourseRessource {
	
	CourseDao courseDao;
	
	public CourseRessource(){
		courseDao = new CourseDao();
	}
	
	@GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Course> getAll() {
        return courseDao.getAll();
    }
	
	@GET @Path("/{courseId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Course getCourse(@PathParam("courseId")int courseId){
		return courseDao.read(courseId);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void newCourse(CourseImpl course){
		courseDao.create(course);
	}
	
	@PUT @Path("/{courseId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateCourse(CourseImpl course){
		courseDao.update(course);
	}
	
	@DELETE @Path("/{sessionId}")
	public void deleteSession(@PathParam("sessionId") int sessionId){
		courseDao.delete(sessionId);
	}
	

}
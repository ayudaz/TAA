package fr.istic.taa.yeoman.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.istic.yeoman.api.Course;
import fr.istic.yeoman.api.GpsPoint;
import fr.istic.yeoman.api.Session;

@Entity
@Table(name="courses")
public class CourseImpl implements Course {
	
	private int id;
	private Session session;
	private List<GpsPoint> gpsPoints;
	
	public CourseImpl(){
		gpsPoints = new ArrayList<GpsPoint>();
	}
	
	@Override
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	@OneToOne(targetEntity=SessionImpl.class)
	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	@OneToMany(targetEntity=GpsPointImpl.class, mappedBy="course")
	public List<GpsPoint> getGPSPoints() {
		return gpsPoints;
	}

	@Override
	public void setGPSPoints(List<GpsPoint> gpsPoints){
		this.gpsPoints = gpsPoints;
	}
}

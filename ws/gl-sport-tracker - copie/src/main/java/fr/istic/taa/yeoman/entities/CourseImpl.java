package fr.istic.taa.yeoman.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.istic.yeoman.api.Course;
import fr.istic.yeoman.api.GPSPoint;
import fr.istic.yeoman.api.Session;

@Entity
@Table(name="courses")
public class CourseImpl implements Course{
	
	private int id;
	private Session session;
	private List<GPSPoint> gpsPoints;
	
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
	@OneToMany(targetEntity=GPSPointImpl.class, mappedBy="course")
	public List<GPSPoint> getGPSPoints() {
		return gpsPoints;
	}

	@Override
	public void setGPSPoints(List<GPSPoint> gpsPoints){
		this.gpsPoints = gpsPoints;
	}
}

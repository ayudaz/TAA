package fr.istic.taa.yeoman.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import fr.istic.yeoman.api.Course;

@Entity
@Table(name="courses")
public class CourseImpl implements Course {
	
	private int id;
	private SessionImpl session;
	private List<GpsPointImpl> gpsPoints;
	
	public CourseImpl(){
		gpsPoints = new ArrayList<GpsPointImpl>();
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
	public SessionImpl getSession() {
		return session;
	}

	@Override
	public void setSession(SessionImpl session) {
		this.session = session;
	}

	@Override
	@OneToMany(targetEntity=GpsPointImpl.class, mappedBy="course")
	@XmlTransient
	@JsonIgnore
	public List<GpsPointImpl> getGPSPoints() {
		return gpsPoints;
	}

	@Override
	public void setGPSPoints(List<GpsPointImpl> gpsPoints){
		this.gpsPoints = gpsPoints;
	}
}

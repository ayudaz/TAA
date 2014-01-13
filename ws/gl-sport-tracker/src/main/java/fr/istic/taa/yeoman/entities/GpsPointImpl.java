package fr.istic.taa.yeoman.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.istic.yeoman.api.GpsPoint;

@Entity
@Table(name="gpspoints")
public class GpsPointImpl implements GpsPoint {
	
	public int id;
	public double x;
	public double y;
	public double z;
	public double heartRate;
	public CourseImpl course;

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
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public double getHeartRate() {
		return heartRate;
	}

	@Override
	public void setHeartRate(double heartRate) {
		this.heartRate = heartRate;
	}

	@Override
	@ManyToOne(targetEntity=CourseImpl.class)
	public CourseImpl getCourse() {
		return course;
	}

	@Override
	public void setCourse(CourseImpl course) {
		this.course = course;
	}

}

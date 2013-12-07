package fr.istic.yeoman.api;

public interface GPSPoint {
	
	// Attributes
	public int getId();
	public void setId(int id);
	public double getX();
	public void setX(double x);
	public double getY();
	public void setY(double y);
	public double getZ();
	public void setZ(double z);
	public double getHeartRate();
	public void setHeartRate(double heartRate);
	
	// Links with others interfaces
	public Course getCourse();
	public void setCourse(Course course);
	
}

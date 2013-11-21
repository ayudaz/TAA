package fr.istic.yeoman.api;

import java.util.List;

public interface Course {
	
	// Attributes
	public int getId();
	public void setId(int id);
	
	// Links with others interfaces
	public Session getSession();
	public List<GPSPoint> getGPSPoints();
}

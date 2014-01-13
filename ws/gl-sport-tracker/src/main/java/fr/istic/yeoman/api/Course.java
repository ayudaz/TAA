package fr.istic.yeoman.api;

import java.util.List;

import fr.istic.taa.yeoman.entities.GpsPointImpl;
import fr.istic.taa.yeoman.entities.SessionImpl;

public interface Course {
	
	// Attributes
	public int getId();
	public void setId(int id);
	
	// Links with others interfaces
	public SessionImpl getSession();
	public void setSession(SessionImpl session);
	public List<GpsPointImpl> getGPSPoints();
	public void setGPSPoints(List<GpsPointImpl> gpsPoints);
}

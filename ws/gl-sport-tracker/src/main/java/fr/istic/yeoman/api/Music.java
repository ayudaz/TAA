package fr.istic.yeoman.api;

import java.util.List;

import fr.istic.taa.yeoman.entities.SessionImpl;

public interface Music {

	// Attributes
	public int getId();
	public void setId(int id);
	public String getName();
	public void setName(String name);
	public String getPath();
	public void setPath(String path);
	
	// internal methods
	public void play();
	
	// link with other interfaces
	public List<SessionImpl> getSessions();
	public void setSessions(List<SessionImpl> sessions);
}

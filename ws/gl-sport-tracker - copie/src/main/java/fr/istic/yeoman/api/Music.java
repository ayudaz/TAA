package fr.istic.yeoman.api;

import java.util.List;

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
	public List<Session> getSessions();
	public void setSessions(List<Session> sessions);
}

package fr.istic.yeoman.api;

import java.util.Date;
import java.util.List;

import fr.istic.taa.yeoman.entities.SessionImpl;

public interface User {
	
	// Attributes
	public int getId();
	public void setId(int id);
	public String getLastName();
	public void setLastName(String lastName);
	public String getFirstName();
	public void setFirstName(String firstName);
	public Date getBirthDay();
	public void setBirthDay(Date birthDate);
	public double getWeight();
	public void setWeight(double weight);
	public int getSize();
	public void setSize(int size);
	public String getPseudo();
	public void setPseudo(String pseudo);
	public boolean getSex();
	public void setSex(boolean sex);
	public String getFacebook();
	public void setFacebook(String facebook);
	public String getTwitter();
	public void setTwitter(String twitter);
	public String getMail();
	public void setMail(String mail);
	public String getPassword();
	public void setPassword(String password);
	public String getAvatar();
	public void setAvatar(String avatar);
	
	// Links with others interfaces
	public List<SessionImpl> getSessions();
	public void addSession(SessionImpl session);
	public void addSession(SessionImpl session, boolean set);
	public void removeSession(SessionImpl session);
	public void emptySession();
	public void setSessions(List<SessionImpl> sessions);
	
}

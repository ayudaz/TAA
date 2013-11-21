package fr.istic.yeoman.api;

import java.util.Date;
import java.util.List;

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
	public String getAvatar();
	public void setAvatar(String avatar);
	
	// Links with others interfaces
	public List<User> amis();
	public List<Session> seances();
}

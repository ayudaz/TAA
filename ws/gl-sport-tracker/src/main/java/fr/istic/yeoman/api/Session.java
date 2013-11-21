package fr.istic.yeoman.api;

import java.sql.Timestamp;
import java.util.List;

public interface Session {
	
	// Attributes
	public int getId();
	public void setId(int id);
	public Timestamp getStartDate();
	public void setStartDate(Timestamp startDate);
	public Timestamp getEndDate();
	public void setEndDate(Timestamp endDate);
	public Mode getMode();
	public void setMode(Mode mode);
	
	// internal methods
	public void start();
	public void timeout();
	public void stop();
	
	// link with other interfaces
	public SportType getSportType();
	public void setSportType(SportType sportType);
	public List<Music> getMusics();
	public void addMusic(Music music);
	public void removeMusic(Music music);
	public void emptyMusic();
	
	
	
	
}

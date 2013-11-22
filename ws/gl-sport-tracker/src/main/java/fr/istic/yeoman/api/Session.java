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
	public Weather getWeather();
	public void setWeather(Weather weather);
	public Goal getGoal();
	public void setGoal(Goal goal);
	public Course getCourse();
	public void setCourse(Course course);
	public User getUser();
	public void setUser(User user);
}

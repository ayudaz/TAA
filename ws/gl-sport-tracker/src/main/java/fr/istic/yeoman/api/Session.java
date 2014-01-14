package fr.istic.yeoman.api;

import java.util.Date;
import java.util.List;

import fr.istic.taa.yeoman.entities.CourseImpl;
import fr.istic.taa.yeoman.entities.GoalImpl;
import fr.istic.taa.yeoman.entities.MusicImpl;
import fr.istic.taa.yeoman.entities.SportTypeImpl;
import fr.istic.taa.yeoman.entities.UserImpl;
import fr.istic.taa.yeoman.entities.WeatherImpl;

public interface Session {
	
	// Attributes
	public int getId();
	public void setId(int id);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public Mode getMode();
	public void setMode(Mode mode);
	
	// internal methods
	public void start();
	public void stop();
	
	// link with other interfaces
	public SportTypeImpl getSportType();
	public void setSportType(SportTypeImpl sportType);
	public List<MusicImpl> getMusics();
	public void setMusics(List<MusicImpl> musics);
	public void addMusic(MusicImpl music);
	public void removeMusic(MusicImpl music);
	public void emptyMusic();
	public WeatherImpl getWeather();
	public void setWeather(WeatherImpl weather);
	public GoalImpl getGoal();
	public void setGoal(GoalImpl goal);
	public CourseImpl getCourse();
	public void setCourse(CourseImpl course);
	public UserImpl getUser();
	public void setUser(UserImpl user);
}

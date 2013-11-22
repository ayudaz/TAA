package fr.istic.taa.yeoman.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.istic.yeoman.api.Course;
import fr.istic.yeoman.api.Goal;
import fr.istic.yeoman.api.Mode;
import fr.istic.yeoman.api.Music;
import fr.istic.yeoman.api.Session;
import fr.istic.yeoman.api.SportType;
import fr.istic.yeoman.api.User;
import fr.istic.yeoman.api.Weather;

@Entity
@Table(name="sessions")
public class SessionImpl implements Session {
	
	private int id;
	private Timestamp startDate;
	private Timestamp endDate;
	private Mode mode;
	private User user;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Override
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the dateDebut
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Override
	public Timestamp getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the dateDebut to set
	 */
	@Override
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the dateFin
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Override
	public Timestamp getEndDate() {
		return endDate;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	@Override
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the mode
	 */
	@Enumerated(EnumType.STRING)
	@Override
	public Mode getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	@Override
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void timeout() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SportType getSportType() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setSportType(SportType sportType) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Music> getMusics() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addMusic(Music music) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeMusic(Music music) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void emptyMusic() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Weather getWeather() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setWeather(Weather weather) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Goal getGoal() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setGoal(Goal goal) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Course getCourse() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCourse(Course course) {
		// TODO Auto-generated method stub
		
	}
	@ManyToOne
	@Override
	public User getUser() {
		return user;
	}
	@Override
	public void setUser(User user) {
		this.user = user;
	}
	
}

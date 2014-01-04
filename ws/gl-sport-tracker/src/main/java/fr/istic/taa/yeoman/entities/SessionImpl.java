package fr.istic.taa.yeoman.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private Date startDate;
	private Date endDate;
	private Mode mode;
	private User user;
	private SportType sportType;
	private List<Music> musics;
	private Weather weather;
	private Goal goal;
	private Course course;
	
	public SessionImpl() {
		musics = new ArrayList<Music>();
	}
	
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
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the dateDebut to set
	 */
	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the dateFin
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Override
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * @param dateFin the dateFin to set
	 */
	@Override
	public void setEndDate(Date endDate) {
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
		this.startDate = Calendar.getInstance().getTime();
	}
	
	@Override
	public void stop() {
		this.endDate = Calendar.getInstance().getTime();
	}
	
	@Override
	@ManyToOne(targetEntity=SportTypeImpl.class)
	public SportType getSportType() {
		return sportType;
	}

	@Override
	public void setSportType(SportType sportType) {
		this.sportType = sportType;
	}
	
	@Override
	@ManyToMany(targetEntity=MusicImpl.class, mappedBy="sessions")
	public List<Music> getMusics() {
		return musics;
	}
	
	@Override
	public void setMusics(List<Music> musics){
		this.musics = musics;
	}
	
	@Override
	public void addMusic(Music music) {
		musics.add(music);
	}
	
	@Override
	public void removeMusic(Music music) {
		musics.remove(music);
	}
	
	@Override
	public void emptyMusic() {
		musics.clear();
	}
	
	@Override
	@OneToOne(targetEntity=WeatherImpl.class)
	public Weather getWeather() {
		return weather;
	}
	
	@Override
	public void setWeather(Weather weather) {
		this.weather = weather; 
	}
	
	@Override
	@OneToOne(targetEntity=GoalImpl.class)
	public Goal getGoal() {
		return goal;
	}
	
	@Override
	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	@Override
	@OneToOne(targetEntity=CourseImpl.class)
	public Course getCourse() {
		return course;
	}
	
	@Override
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Override
	@ManyToOne(targetEntity=UserImpl.class)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	public User getUser() {
		return user;
	}
	
	@Override
	public void setUser(User user) {
		setUser(user, true);
	}

	public void setUser(User user, boolean add) {
		this.user = user;
		if(user != null && add){
			user.addSession(this, false);
		}
	}
}

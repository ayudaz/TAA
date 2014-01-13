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

import fr.istic.yeoman.api.Mode;
import fr.istic.yeoman.api.Session;

@Entity
@Table(name="sessions")
public class SessionImpl implements Session {
	
	private int id;
	private Date startDate;
	private Date endDate;
	private Mode mode;
	private UserImpl user;
	private SportTypeImpl sportType;
	private List<MusicImpl> musics;
	private WeatherImpl weather;
	private GoalImpl goal;
	private CourseImpl course;
	
	public SessionImpl() {
		musics = new ArrayList<MusicImpl>();
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
	public SportTypeImpl getSportType() {
		return sportType;
	}

	@Override
	public void setSportType(SportTypeImpl sportType) {
		this.sportType = sportType;
	}
	
	@Override
	@ManyToMany(targetEntity=MusicImpl.class, mappedBy="sessions")
	public List<MusicImpl> getMusics() {
		return musics;
	}
	
	@Override
	public void setMusics(List<MusicImpl> musics){
		this.musics = musics;
	}
	
	@Override
	public void addMusic(MusicImpl music) {
		musics.add(music);
	}
	
	@Override
	public void removeMusic(MusicImpl music) {
		musics.remove(music);
	}
	
	@Override
	public void emptyMusic() {
		musics.clear();
	}
	
	@Override
	@OneToOne(targetEntity=WeatherImpl.class)
	public WeatherImpl getWeather() {
		return weather;
	}
	
	@Override
	public void setWeather(WeatherImpl weather) {
		this.weather = weather; 
	}
	
	@Override
	@OneToOne(targetEntity=GoalImpl.class)
	public GoalImpl getGoal() {
		return goal;
	}
	
	@Override
	public void setGoal(GoalImpl goal) {
		this.goal = goal;
	}
	
	@Override
	@OneToOne(targetEntity=CourseImpl.class)
	public CourseImpl getCourse() {
		return course;
	}
	
	@Override
	public void setCourse(CourseImpl course) {
		this.course = course;
	}
	
	@Override
	@ManyToOne(targetEntity=UserImpl.class)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	public UserImpl getUser() {
		return user;
	}
	
	@Override
	public void setUser(UserImpl user) {
		setUser(user, true);
	}

	public void setUser(UserImpl user, boolean add) {
		this.user = user;
		if(user != null && add){
			user.addSession(this, false);
		}
	}
}

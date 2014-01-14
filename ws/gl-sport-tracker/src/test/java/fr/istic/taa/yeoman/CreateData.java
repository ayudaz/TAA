package fr.istic.taa.yeoman;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.istic.taa.yeoman.dao.*;
import fr.istic.taa.yeoman.entities.*;
import fr.istic.yeoman.api.*;


public class CreateData {
	/**
     * @param args
     */
    public static void main(String[] args) {
    	CourseImpl course = new CourseImpl();
    	GoalImpl goal = new GoalImpl();
    	GpsPointImpl gpsPoint = new GpsPointImpl();
    	MusicImpl music = new MusicImpl();
    	SessionImpl session = new SessionImpl();
    	SportTypeImpl sportType = new SportTypeImpl();
    	UserImpl user = new UserImpl();
    	WeatherImpl weather = new WeatherImpl();
    	
    	
    	CourseDao courseDao = new CourseDao();
    	GoalDao goalDao = new GoalDao();
    	GpsPointDao gpsPointDao = new GpsPointDao();
    	MusicDao musicDao = new MusicDao();
    	SessionDao sessionDao = new SessionDao();
    	SportTypeDao sportTypeDao = new SportTypeDao();
    	UserDao userDao = new UserDao();
    	WeatherDao weatherDao = new WeatherDao();
    	
    	goal.setGoalType(GoalType.distance);
    	goal.setValue(5);
    	
    	gpsPoint.setHeartRate(90);
    	gpsPoint.setX(0);
    	gpsPoint.setY(0);
    	gpsPoint.setZ(0);
    	
    	music.setName("Get Lucky");
    	music.setPath("/musique/get_lucky.mp3");
    	
    	
    	session.setEndDate(new Date(2014, 1, 13, 9, 50, 0));
    	session.setMode(Mode.distance);
    	session.setStartDate(new Date(2014, 1, 13, 9, 0, 0));
    	
    	
    	sportType.setIcon("/icons/icon1.jpeg");
    	sportType.setName("Course");
    	
    	user.setAvatar("/avatat/avatar1.jpg");
    	user.setBirthDay(new Date(1990, 11, 30));
    	user.setFirstName("Thomas");
    	user.setLastName("Lelièvre");
    	user.setMail("thomas11@gmail.com");
    	user.setPassword("azerty");
    	user.setPseudo("blablaaa");
    	user.setSex(true);
    	user.setSize(171);
    	user.setWeight(81);
    	
    	weather.setTemperature(21);
    	weather.setWeatherState(WeatherState.sunny);
    	weather.setWind(10);
    	
    	courseDao.create(course);
    	goalDao.create(goal);
    	gpsPointDao.create(gpsPoint);
    	musicDao.create(music);
    	sessionDao.create(session);
    	sportTypeDao.create(sportType);
    	userDao.create(user);
    	weatherDao.create(weather);
    	
    	List<GpsPointImpl> l = new ArrayList<GpsPointImpl>();
    	l.add(gpsPoint);
    	course.setGPSPoints(l);
    	course.setSession(session);
    	courseDao.update(course);
    	
    	gpsPoint.setCourse(course);
    	gpsPointDao.update(gpsPoint);
    	
    	List<SessionImpl> l2 = new ArrayList<SessionImpl>();
    	l2.add(session);
    	music.setSessions(l2);
    	musicDao.update(music);
    	
    	session.setCourse(course);
    	session.setGoal(goal);
    	List<MusicImpl> musics = new ArrayList<MusicImpl>();
    	musics.add(music);
    	session.setMusics(musics);
    	session.setSportType(sportType);
    	session.setUser(user);
    	session.setWeather(weather);
//    	sessionDao.update(session);
    	
    	user.setSessions(l2);
    	userDao.update(user);
    	
    	weather.setSession(session);
    	weatherDao.update(weather);
    }
}

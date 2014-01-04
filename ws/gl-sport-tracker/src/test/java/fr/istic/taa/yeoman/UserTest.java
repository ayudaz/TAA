package fr.istic.taa.yeoman;

import java.util.Calendar;
import java.util.Date;

import fr.istic.taa.yeoman.dao.SessionDao;
import fr.istic.taa.yeoman.dao.UserDao;
import fr.istic.taa.yeoman.entities.SessionImpl;
import fr.istic.taa.yeoman.entities.UserImpl;
import fr.istic.yeoman.api.Session;
import fr.istic.yeoman.api.User;


public class UserTest {
	/**
     * @param args
     */
    public static void main(String[] args) {
    	
    	UserDao userDao = new UserDao();
    	
    	UserImpl user = userDao.read(1);
    	
    	SessionDao sessionDao = new SessionDao();
    	
    	SessionImpl session = sessionDao.read(1);
    	
    	System.out.println(user.getSessions());
    }
}

package fr.istic.taa.yeoman;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import fr.istic.taa.yeoman.dao.UserDAO;
import fr.istic.taa.yeoman.entities.UserImpl;
import fr.istic.yeoman.api.User;

public class UserTest {
	/**
     * @param args
     */
    public static void main(String[] args) {
    	UserDAO dao = new UserDAO();
    	
    	User tt = new UserImpl();
    	tt.setFirstName("Titi");
    	tt.setLastName("Tata");
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	try {
			tt.setBirthDay(sdf.parse("30/11/1990"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	tt.setPseudo("azerty");
    	tt.setMail("toto@gmail.com");
    	tt.setSex(true);
    	tt.setSize(170);
    	tt.setWeight(75.0);
    	
    	dao.create(tt);
    	
    	List<User> allUsers = dao.getAllUsers();
    	
    	for (User user : allUsers) {
			System.out.println(user);
		}
    }
}

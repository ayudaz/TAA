package fr.istic.taa.yeoman.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import fr.istic.yeoman.api.Session;
import fr.istic.yeoman.api.User;



@Entity
@Table(name="users")
@XmlRootElement
public class UserImpl implements User {

	private int id;
	private String lastName;
	private String firstName;
	private Date birthDay;
	private double weight;
	private int size;
	private String pseudo;
	private boolean sex;
	private String facebook;
	private String twitter;
	private String mail;
	private String avatar;
	private List<Session> sessions;
	
	public UserImpl(){
		sessions = new ArrayList<Session>();
	}
	
	@Override
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=50, nullable=false)
	@Override
	public String getLastName() {
		return lastName;
	}
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(length=50, nullable=false)
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Temporal(TemporalType.DATE)
	@Override
	public Date getBirthDay() {
		return birthDay;
	}
	@Override
	public void setBirthDay(Date birthDate) {
		this.birthDay = birthDate;
	}
	@Override
	public double getWeight() {
		return weight;
	}
	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public void setSize(int size) {
		this.size = size;
	}
	@Column(length=30, unique=true, nullable=false)
	@Override
	public String getPseudo() {
		return pseudo;
	}
	@Override
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	@Column(nullable=false)
	@Override
	public boolean getSex() {
		return sex;
	}
	@Override
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	@Column(length=100)
	@Override
	public String getFacebook() {
		return facebook;
	}
	@Override
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	@Column(length=100)
	@Override
	public String getTwitter() {
		return twitter;
	}
	@Override
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	@Column(length=100, nullable=false, unique=true)
	@Override
	public String getMail() {
		return mail;
	}
	@Override
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Column(length=100)
	@Override
	public String getAvatar() {
		return avatar;
	}
	@Override
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@OneToMany(targetEntity=SessionImpl.class, mappedBy="user")
	@XmlTransient
	@JsonIgnore
	@Override
	public List<Session> getSessions() {
		return sessions;
	}
	@Override
	public void setSessions(List<Session> sessions){
		this.sessions = sessions;
	}
	@Override
	public void addSession(Session session) {
		addSession(session, true);
	}
	
	public void addSession(Session session, boolean set){
		if (session != null) {
            if(getSessions().contains(session)) {
                getSessions().set(getSessions().indexOf(session), session);
            }
            else {
                getSessions().add(session);
            }
            if (set) {
                session.setUser((User)this, false);
            }
        }
	}
	@Override
	public void removeSession(Session session) {
		getSessions().remove(session);
		session.setUser(null);
	}
	@Override
	public void emptySession() {
		sessions.clear();
	}
	
}

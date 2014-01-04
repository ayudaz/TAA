package fr.istic.taa.yeoman.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fr.istic.yeoman.api.Music;
import fr.istic.yeoman.api.Session;

@Entity
@Table(name="musics")
public class MusicImpl implements Music {
	
	public int id;
	public String name;
	public String path;
	public List<Session> sessions;
	
	public MusicImpl() {
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
	
	@Override
	@Column(length=100)
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	@Column(length=200)
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

	@Override
	@ManyToMany(targetEntity=SessionImpl.class)
	public List<Session> getSessions() {
		return sessions;
	}
	
	@Override
	public void setSessions(List<Session> sessions){
		this.sessions = sessions;
	}

}

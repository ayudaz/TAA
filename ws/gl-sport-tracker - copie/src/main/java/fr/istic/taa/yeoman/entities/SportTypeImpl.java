package fr.istic.taa.yeoman.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.istic.yeoman.api.SportType;

@Entity
@Table(name="sporttypes")
public class SportTypeImpl implements SportType {
	
	public int id;
	public String name;
	public String icon;

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
	@Column(length=300)
	public String getIcon() {
		return icon;
	}

	@Override
	public void setIcon(String icon) {
		this.icon = icon;
	}

}

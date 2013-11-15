package fr.istic.taa.yeoman.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sessions")
public class Session {
	
	private Date dateDebut;
	private Date dateFin;
	private Mode mode;
}

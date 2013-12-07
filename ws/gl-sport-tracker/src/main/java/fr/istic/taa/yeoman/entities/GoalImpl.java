package fr.istic.taa.yeoman.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.istic.yeoman.api.Goal;
import fr.istic.yeoman.api.GoalType;
import fr.istic.yeoman.api.Session;

@Entity
@Table(name="goals")
public class GoalImpl implements Goal {
	
	public int id;
	public GoalType goalType;
	public double value;
	public List<Session> sessions;

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
	@Enumerated(EnumType.STRING)
	public GoalType getGoalType() {
		return goalType;
	}

	@Override
	public void setGoalType(GoalType goalType) {
		this.goalType = goalType;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	@OneToMany(targetEntity=SessionImpl.class, mappedBy="goal")
	public List<Session> sessions() {
		return sessions;
	}

}

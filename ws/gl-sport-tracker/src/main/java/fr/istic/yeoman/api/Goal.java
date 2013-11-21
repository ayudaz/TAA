package fr.istic.yeoman.api;

import java.util.List;

public interface Goal {

	// Attributes
	public int getId();
	public void setId(int id);
	public GoalType getGoalType();
	public void setGoalType(GoalType goalType);
	public double getValue();
	public void setValue(double value);
	
	// links with others interfaces
	public List<Session> sessions();
}

package fr.istic.yeoman.api;

import fr.istic.taa.yeoman.entities.SessionImpl;

public interface Weather {
	
	// Attributes
	public int getId();
	public void setId(int id);
	public double getTemperature();
	public void setTemperature(double temperature);
	public WeatherState getWeatherState();
	public void setWeatherState(WeatherState weatherState);
	public double getWind();
	public void setWind(double wind);
	
	// links with others interfaces
	public SessionImpl getSession();
	public void setSession(SessionImpl session);
}

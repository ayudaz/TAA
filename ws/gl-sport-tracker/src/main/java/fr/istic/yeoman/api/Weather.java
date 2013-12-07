package fr.istic.yeoman.api;

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
	public Session getSession();
	public void setSession(Session session);
}

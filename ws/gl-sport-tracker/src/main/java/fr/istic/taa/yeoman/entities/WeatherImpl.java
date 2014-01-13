package fr.istic.taa.yeoman.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.istic.yeoman.api.Weather;
import fr.istic.yeoman.api.WeatherState;

@Entity
@Table(name="weathers")
public class WeatherImpl implements Weather {
	
	public int id;
	public double temperature;
	public WeatherState weatherState;
	public double wind;
	public SessionImpl session;

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
	public double getTemperature() {
		return temperature;
	}

	@Override
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	@Enumerated(EnumType.STRING)
	public WeatherState getWeatherState() {
		return weatherState;
	}

	@Override
	public void setWeatherState(WeatherState weatherState) {
		this.weatherState = weatherState;
	}

	@Override
	public double getWind() {
		return wind;
	}

	@Override
	public void setWind(double wind) {
		this.wind = wind;
	}

	@Override
	@OneToOne(targetEntity=SessionImpl.class)
	public SessionImpl getSession() {
		return session;
	}
	
	@Override
	public void setSession(SessionImpl session){
		this.session = session;
	}

}

package exercise.candoit.exerciseCandoit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
	@JsonProperty("humidity")
	public int getHumidity() {
		return this.humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	int humidity;

	@JsonProperty("pressure")
	public double getPressure() {
		return this.pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	double pressure;

	@JsonProperty("st")
	public double getSt() {
		return this.st;
	}

	public void setSt(double st) {
		this.st = st;
	}

	double st;

	@JsonProperty("visibility")
	public double getVisibility() {
		return this.visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	double visibility;

	@JsonProperty("wind_speed")
	public int getWind_speed() {
		return this.wind_speed;
	}

	public void setWind_speed(int wind_speed) {
		this.wind_speed = wind_speed;
	}

	int wind_speed;

	@JsonProperty("id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	int id;

	@JsonProperty("description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	String description;

	@JsonProperty("temp")
	public double getTemp() {
		return this.temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	double temp;

	@JsonProperty("wing_deg")
	public String getWing_deg() {
		return this.wing_deg;
	}

	public void setWing_deg(String wing_deg) {
		this.wing_deg = wing_deg;
	}

	String wing_deg;

	@JsonProperty("tempDesc")
	public String getTempDesc() {
		return this.tempDesc;
	}

	public void setTempDesc(String tempDesc) {
		this.tempDesc = tempDesc;
	}

	String tempDesc;
}

package exercise.candoit.exerciseCandoit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	
	@JsonProperty("_id")
	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	String _id;

	@JsonProperty("dist")
	public double getDist() {
		return this.dist;
	}

	public void setDist(double dist) {
		this.dist = dist;
	}

	double dist;

	@JsonProperty("lid")
	public int getLid() {
		return this.lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	int lid;

	@JsonProperty("fid")
	public int getFid() {
		return this.fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	int fid;

	@JsonProperty("int_number")
	public int getInt_number() {
		return this.int_number;
	}

	public void setInt_number(int int_number) {
		this.int_number = int_number;
	}

	int int_number;

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;

	@JsonProperty("province")
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	String province;

	@JsonProperty("lat")
	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	String lat;

	@JsonProperty("lon")
	public String getLon() {
		return this.lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	String lon;

	@JsonProperty("zoom")
	public String getZoom() {
		return this.zoom;
	}

	public void setZoom(String zoom) {
		this.zoom = zoom;
	}

	String zoom;

	@JsonProperty("updated")
	public int getUpdated() {
		return this.updated;
	}

	public void setUpdated(int updated) {
		this.updated = updated;
	}

	int updated;

	@JsonProperty("weather")
	public Weather getWeather() {
		return this.weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	Weather weather;

	@JsonProperty("forecast")
	public Object getForecast() {
		return this.forecast;
	}

	public void setForecast(Object forecast) {
		this.forecast = forecast;
	}

	Object forecast;
}

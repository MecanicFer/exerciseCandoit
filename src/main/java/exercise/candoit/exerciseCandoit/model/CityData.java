package exercise.candoit.exerciseCandoit.model;

public class CityData {
    private String cityName;
    private double temperature;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

	public CityData(String cityName, double temperature) {
		super();
		this.cityName = cityName;
		this.temperature = temperature;
	}

	public CityData() {
	}
    
}

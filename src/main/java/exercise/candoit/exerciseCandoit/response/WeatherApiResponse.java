package exercise.candoit.exerciseCandoit.response;

import java.util.List;

import exercise.candoit.exerciseCandoit.model.CityData;

public class WeatherApiResponse {
    private List<CityData> cityDataList;

    public List<CityData> getCityDataList() {
        return cityDataList;
    }

    public void setCityDataList(List<CityData> cityDataList) {
        this.cityDataList = cityDataList;
    }
}
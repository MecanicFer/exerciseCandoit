package exercise.candoit.exerciseCandoit.component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import exercise.candoit.exerciseCandoit.entity.WeatherData;
import exercise.candoit.exerciseCandoit.model.Location;
import exercise.candoit.exerciseCandoit.repository.WeatherDataRepository;
import exercise.candoit.exerciseCandoit.service.WeatherService;

@Component
public class ScheduledJob {

	private static final Logger LOGGER = LogManager.getLogger(ScheduledJob.class);

	@Autowired
	WeatherService weatherService;

	@Autowired
	WeatherDataRepository weatherDataRepository;

	@Scheduled(fixedRate = 300000)
	public void updateWeatherData() {
		try {
			LOGGER.info("Actualizando registros del clima en BD");

			List<Location> locations = weatherService.getWeather();
			List<WeatherData> weatherDataList = mapLocationsToWeatherData(locations);

			if (!weatherDataList.isEmpty()) {
				weatherDataRepository.deleteAll();
				weatherDataRepository.flush();
			}

			if (!weatherDataList.isEmpty()) {
				weatherDataRepository.saveAll(weatherDataList);
				weatherDataRepository.flush();
			}

			LOGGER.info("Data actualizada correctamente");
		} catch (Exception e) {
			LOGGER.error("Error al actualizar los registros del clima en BD: " + e.getMessage(), e);
		}
	}

	public List<WeatherData> mapLocationsToWeatherData(List<Location> locations) {
		return locations.stream().map(location -> {
			WeatherData weatherData = new WeatherData();
			weatherData.setCity(location.getName());
			weatherData.setTemperature(location.getWeather().getTemp());
			weatherData.setTimestamp(new Date());
			weatherData.setProvince(location.getProvince());
			weatherData.setLon(location.getLon());
			weatherData.setLat(location.getLat());
			return weatherData;
		}).collect(Collectors.toList());
	}
}
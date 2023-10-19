package exercise.candoit.exerciseCandoit.service;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import exercise.candoit.exerciseCandoit.model.Location;

@Service
public class WeatherService {

	private static final Logger LOGGER = LogManager.getLogger(WeatherService.class);

	@Value("${custom.api.weather-url}")
	private String weatherUrl;

	private final RestTemplate restTemplate;

	public WeatherService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Location> getWeather() {
		List<Location> updatedData = new ArrayList<>();
		try {
			LOGGER.info("Updating weather data every 2 seconds");
			ResponseEntity<List<Location>> responseEntity = restTemplate.exchange(weatherUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Location>>() {
					});
			updatedData = responseEntity.getBody();
		} catch (RestClientException e) {
			LOGGER.info("Ocurrio un error al consumir el servicio externo del clima", e);
		}
		return updatedData;
	}

}
package exercise.candoit.exerciseCandoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.candoit.exerciseCandoit.constant.ViewConstant;
import exercise.candoit.exerciseCandoit.entity.WeatherData;
import exercise.candoit.exerciseCandoit.repository.WeatherDataRepository;
import java.util.List;

@RequestMapping("/vistasUser")
@Controller
public class WeatherController {

	@Autowired
	WeatherDataRepository weatherDataRepository;

	@GetMapping("/weather")
	public String getWeatherData(Model model) {
		try {
			List<WeatherData> weatherDataList = weatherDataRepository.findAll();

			if (!weatherDataList.isEmpty()) {
				model.addAttribute("weatherDataList", weatherDataList);
			} else {
				model.addAttribute("message", "No se encontraron datos de clima.");
			}
		} catch (Exception e) {
			model.addAttribute("error", "Error al recuperar los datos de clima: " + e.getMessage());
		}

		return ViewConstant.WEATHER;
	}

}

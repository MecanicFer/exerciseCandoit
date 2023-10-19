package exercise.candoit.exerciseCandoit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "exercise.candoit")
@EnableScheduling
public class ExerciseCandoitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseCandoitApplication.class, args);
	}

}

package td.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"td.dao","td.service","td.ihm"})
public class AppConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

}

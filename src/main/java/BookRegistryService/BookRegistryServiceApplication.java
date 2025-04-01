package BookRegistryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookRegistryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookRegistryServiceApplication.class, args);
	}
}

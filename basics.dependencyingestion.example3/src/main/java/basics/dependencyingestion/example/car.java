package basics.dependencyingestion.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class car implements vehicle {
	
	@Bean
	public void drive() {
		System.out.println("Car is running"); 
	}
}

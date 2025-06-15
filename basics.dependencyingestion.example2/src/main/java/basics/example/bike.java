package basics.example;

import org.springframework.stereotype.Component;

@Component
public class bike implements vehicle {
	public void drive() {
		System.out.println("Bike is running"); 
	}
}

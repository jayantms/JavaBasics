package basics.dependencyingestion.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class basics1 {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
		
		vehicle veh1 = (vehicle) context.getBean(car.class); 
		veh1.drive();
	}
}

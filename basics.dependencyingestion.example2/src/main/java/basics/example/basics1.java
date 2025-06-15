package basics.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class basics1 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 
		
		vehicle veh1 = (vehicle) context.getBean("bike"); 
		veh1.drive();
	}
}

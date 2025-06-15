package basics.collections.listinterface;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {

		List<Employee> llinkedList = new LinkedList<Employee>();
        Employee l1 = new Employee(1,"Abcd"); 
        Employee l2 = new Employee(2,"Pqrs"); 
        Employee l3 = new Employee(3,"rstv"); 
        Employee l4 = new Employee(4,"lmno"); 

        llinkedList.add(l1);
        llinkedList.add(l2);
        llinkedList.add(l3);
        llinkedList.add(l4);
        
        for(Employee emp: llinkedList) {
        	System.out.println(emp.toString()); 
        }
	}
}

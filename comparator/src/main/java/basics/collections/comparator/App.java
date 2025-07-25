package basics.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	List<Employee> tlist = new ArrayList<Employee>(); 
    	
        Employee l1 = new Employee(4,"Abcd"); 
        Employee l2 = new Employee(3,"Pqrs"); 
        Employee l3 = new Employee(2,"rstv"); 
        Employee l4 = new Employee(1,"lmno"); 
        
        tlist.add(l1);  
        tlist.add(l2);  
        tlist.add(l3);  
        tlist.add(l4);

        Comparator<Employee> lcmp = new Comparator<Employee>() { 
        	public int compare(Employee l1, Employee l2) {
        		if(l1.getEmployeeNo() > l2.getEmployeeNo()) 
        			return 1;
        		else
        			return -1; 
        	}
        }; 
        
        Collections.sort(tlist,lcmp);

        tlist.forEach(emp -> System.out.println(emp.toString()));
    }
}

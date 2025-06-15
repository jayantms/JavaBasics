package basics.collections.mapinterface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashmapExample 
{
    public static void main( String[] args )
    {
        Map<Integer, Employee> lmapEmployee = new HashMap<Integer, Employee>();
        
        Employee l1 = new Employee(1,"Abcd"); 
        Employee l2 = new Employee(2,"Pqrs"); 
        Employee l3 = new Employee(3,"rstv"); 
        Employee l4 = new Employee(4,"lmno"); 
        Employee l5 = new Employee(2,"Jklv"); 
        
        lmapEmployee.put(1, l1); 
        lmapEmployee.put(2, l2); 
        lmapEmployee.put(3, l3); 
        lmapEmployee.put(4, l4);
        lmapEmployee.put(2, l5);
        
        for(Map.Entry<Integer, Employee> lemp: lmapEmployee.entrySet()) {
        	System.out.println(lemp.getKey() + " , " + lemp.toString()); 
        }
        
        ////////////////////////

        Employee lempSearch = lmapEmployee.get(3); 
        System.out.println("Seacrhed employee - "+lempSearch.toString()); 
        
        ////////////////////////
        
        Set<Map.Entry<Integer, Employee>> setLmap = lmapEmployee.entrySet(); 
        
        Iterator<Map.Entry<Integer, Employee>> iter = setLmap.iterator(); 
        
        while(iter.hasNext()) {
        	// System.out.println(iter.toString());
        	Map.Entry<Integer, Employee> lemp = iter.next();
        	System.out.println(lemp.getKey() + " , " + lemp.getValue().toString()); 
        }
        
    }
}

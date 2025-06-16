package basics.codingpractice.datastructures;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Maps_Hashtable_usage {

	public static void main(String[] args) {
		
		////////////// Adding data
		Map<Integer, String> lmap = new Hashtable<Integer,String>(); 
		lmap.put(10, "TestA"); 
		lmap.put(20, "TestB"); 
		lmap.put(30, "TestC"); 
		lmap.put(40, "TestD"); 
		lmap.put(50, "TestE"); 

		////////////// Iteration using Map.entry 
		for(Map.Entry<Integer, String> lval : lmap.entrySet()) {
			System.out.println(" Key - "+lval.getKey()+" , Value - "+lval.getValue()); 
		};
		
		System.out.println("---------------------------------");
		
		/////////////// Using iterator 
		Iterator<Map.Entry<Integer, String>> liter = lmap.entrySet().iterator(); 

		while(liter.hasNext()) {
			Map.Entry<Integer, String> liter2 = liter.next(); 
			System.out.println(" Key - " + liter2.getKey() + " , Value - "+liter2.getValue()); 
		}
		
		///////////////////
		System.out.println("---------------------------------");
		
		for(Map.Entry<Integer, String> lval : lmap.entrySet()) {
			System.out.println(" Key - " + lval.getKey() + " , Value - "+lval.getValue());
		}
	}
}

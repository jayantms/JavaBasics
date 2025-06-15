package basics.collections.multithreadedapp;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TransactionHandling {
	Queue lq1; 
	
	TransactionHandling() {
		lq1 = new ConcurrentLinkedQueue<Employee>(); 
	}
	
	public void addRecord(Employee l1) { 
		lq1.add(l1);
	}
	
	public Employee getRecord() { 
		
		if(!lq1.isEmpty()) 
			return (Employee) lq1.remove();
		else 
			return null; 
	}

}

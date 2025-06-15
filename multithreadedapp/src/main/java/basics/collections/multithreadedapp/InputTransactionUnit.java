package basics.collections.multithreadedapp;

public class InputTransactionUnit implements Runnable {
	TransactionHandling lobj; 
	
	InputTransactionUnit(TransactionHandling llobj) {
		lobj = llobj; 
	}

	public void run() {
        Employee l1 = new Employee(1,"Abcd"); 
        Employee l2 = new Employee(2,"Pqrs"); 
        Employee l3 = new Employee(3,"rstv"); 
        Employee l4 = new Employee(4,"lmno"); 
        Employee l5 = new Employee(2,"Jklv");
        
        lobj.addRecord(l1);
        lobj.addRecord(l2);
        lobj.addRecord(l3);
        lobj.addRecord(l4);
	}
}

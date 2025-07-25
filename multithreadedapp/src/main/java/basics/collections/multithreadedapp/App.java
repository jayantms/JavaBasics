package basics.collections.multithreadedapp;


public class App 
{
    public static void main( String[] args )
    {
    	TransactionHandling t1 = new TransactionHandling(); 

    	InputTransactionUnit ip1 = new InputTransactionUnit(t1); 
    	TransactionProcessingUnit w1 = new TransactionProcessingUnit(t1);
    	
    	Thread th1 = new Thread(w1);
    	Thread th2 = new Thread(ip1);
    	
    	th1.start();
    	th2.start();
    }
}

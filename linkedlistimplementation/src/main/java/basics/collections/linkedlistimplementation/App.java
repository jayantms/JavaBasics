package basics.collections.linkedlistimplementation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	LinkedListX<String> ltest = new LinkedListX(); 
    	
    	ltest.insertNode("Abcd");
    	ltest.insertNode("Pqrs");
    	ltest.insertNode("Lmno");
    	ltest.insertNode("Rstv");

    	ltest.displayList();
    	System.out.println("--------------------------------"); 
//    	ltest.removeNode("Lmno");
    	ltest.removeNode("tmpw");
    	ltest.displayList();
    	System.out.println("--------------------------------"); 
    }
}

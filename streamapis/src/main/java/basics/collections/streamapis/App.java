package basics.collections.streamapis;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> ltmpList = Arrays.asList(6,7,8,1,2,3,4,5);
        
        //ltmpList.forEach(val -> System.out.println(val));
        
        //System.out.println(ltmpList.stream().count());
        ltmpList.stream().filter(n -> n%2==1).sorted().forEach(val -> System.out.println(val));
        System.out.println("--------------------------");
        ltmpList.stream().sorted().forEach(val -> System.out.println(val)); 
    }
}

package basics.codingpractice.algorithms;

/**
 * Hello world!
 *
 */
public class binarysearch 
{
    public static void main( String[] args )
    {
        int[] ldata = new int[] {1,2,3,4,5,6,7,8,9,10};
        
        binarySearch(ldata, 2, 0, 9, 5); 
    }
    
    
    public static void binarySearch(int[] ldata, int num, int low, int high, int mid) {
    	if(ldata[mid] == num) { 
    		System.out.println("Found number - "+num+" , at index - "+mid);
    		return; 
    	}

    	if(ldata[low] == num) { 
    		System.out.println("Found number - "+num+" , at index - "+low);
    		return; 
    	}
    	
    	if(ldata[high] == num) { 
    		System.out.println("Found number - "+num+" , at index - "+high);
    		return; 
    	}
    	
    	if(ldata[low] < num && num < ldata[mid] ) {
    		int newmid = (low+mid)/2; 
    		binarySearch(ldata, num, low, mid, newmid); 
    	}else
    	{
    		if(ldata[mid] < num && num < ldata[high] ) 
    		{
    			int newmid = (mid+high)/2;
        		binarySearch(ldata, num, mid, high, newmid); 
    		}
    	}
    }
}

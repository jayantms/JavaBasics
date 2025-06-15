package basics.codingpractice.TwoSum;

public class App 
{
	public static void main(String[] args) {
		int[] nums; 
		int target; 
		int[] lreturns = new int[2]; 
		
		nums = new int[] {3,2,4};
		target = 6; 
		
		boolean lfound = false; 

		for(int i=0 ; i < nums.length ; i++) {
			for(int j = 0 ; j < nums.length ; j++ ) {
				
				
				if((nums[i] + nums[j] == target) && i != j ) {
					System.out.println("Found match - "+nums[i]+ " , "+nums[j]);
					lfound = true; 
					
					lreturns[0] = nums[i]; 
					lreturns[1] = nums[j]; 
					break; 
				}
			}
			
			if(lfound) 
				break; 
		}
	}
}

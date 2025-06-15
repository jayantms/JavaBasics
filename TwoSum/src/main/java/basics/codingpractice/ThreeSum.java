package basics.codingpractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = new int[] {-1,0,1,2,-1,-4}; 
		List<List<Integer>> ylist = new ArrayList<List<Integer>>(); 
		Set<String> chkSet = new HashSet<String>();
		boolean lkeyexists = false; 
		
		for(int i=0 ; i < nums.length ; i++) {
			for(int j=0 ; j < nums.length ; j++) {
				for(int k=0 ; k < nums.length ; k++) {
					if( i != j && j !=k && i != k && (nums[i] + nums[j] + nums[k] == 0)) {
						String key1 = i + ":" + j + ":" + k; 
						String key2 = j + ":" + i + ":" + k; 
						String key3 = j + ":" + k + ":" + i;
						String key4 = k + ":" + j + ":" + i;
						String key5 = k + ":" + i + ":" + j; 
						String key6 = i + ":" + k + ":" + j; 
						
						if(!chkSet.isEmpty()) {
							if(chkSet.contains(key1) || chkSet.contains(key2) || chkSet.contains(key3) || chkSet.contains(key4) || chkSet.contains(key5) || chkSet.contains(key6)) {
								lkeyexists = true; 
							}
						}
						
						if(!lkeyexists) {
							chkSet.add(key1); 
							chkSet.add(key2); 
							chkSet.add(key3); 
							chkSet.add(key4); 
							chkSet.add(key5); 
							chkSet.add(key6); 
							List<Integer> xlist = new ArrayList<Integer>(); 
							xlist.add(Integer.valueOf(i)); 
							xlist.add(Integer.valueOf(j)); 
							xlist.add(Integer.valueOf(j));
							
							System.out.println(" "+nums[i]+ " , "+nums[j]+" , "+nums[k]); 
							ylist.add(xlist);
						}
						
						lkeyexists = false; 
					}
				}
			}
		}
		
	}
}

package basics.codingpractice.algorithms.sortings;

public class mergesort {
	static int[] inpdata = new int[] {7, 34, 89, 56, 12, 74, 21, 95, 53, 68, 2, 45, 81, 17, 63, 99, 31, 76, 42, 90};
	//static int[] inpdata = new int[] {12, 11, 13, 5, 6, 7 };
	

	public static void main(String[] args) {
		
		displayarray(); 
		mergesortarray(0, inpdata.length-1); 
		displayarray(); 
		
	}
	
	public static void displayarray() {
		for(int i: inpdata) {
			System.out.print(i+ ", ");
		}
		System.out.println("\n-------------------------------------------------------------------------------------------------"); 
	}
	
	public static void mergesortarray(int low, int high) {
		int mid = -1; 
		if (low < high) {
			//mid = low + (high-1)/2;
			mid = (low + high)/2;
		}else
			return; 
		
		//System.out.println("low - "+low+" , mid - "+mid+" , high - "+high); 
		
		mergesortarray(low, mid); 
		mergesortarray(mid+1, high); 
		
		merge(low, mid, high); 
	}
	
	
	public static void merge(int low, int mid, int high) 
	{
		int[] lresult = new int[inpdata.length];
		
		int n1 = mid - low + 1; 
		int n2 = high - mid; 
		
		int[] L = new int[n1]; 
		int[] R = new int[n2]; 
		
		for(int i=0 ; i < n1 ; i++) 
			L[i] = inpdata[low+i]; 
		
		for(int j=0 ; j < n2 ; j++) 
			R[j] = inpdata[mid+1+j]; 
		
		
		int i=0, j=0, k=low; 
		
		while(i < n1 && j < n2) 
		{
			if(L[i] <= R[j]) {
			   inpdata[k] = L[i];
			   i++; 
			}else {
			   inpdata[k] = R[j]; 
			   j++; 
			}
			k++; 
		}
		
		while(i < n1) {
		   inpdata[k] = L[i];
		   i++; 
		   k++; 
		}
		
		while(j < n2) {
		   inpdata[k] = R[j]; 
		   j++; 
		   k++; 
		}
	}
}



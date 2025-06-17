package basics.codingpractice.algorithms.sortings;

public class sortalgo {
	public static void main(String[] args) {
		
		int[] inpdata = new int[] {7, 34, 89, 56, 12, 74, 21, 95, 53, 68, 2, 45, 81, 17, 63, 99, 31, 76, 42, 90};
		
		bubblesort(inpdata); 
		
		for(int i: inpdata) {
			System.out.print(i+ ", ");
		}
	}
	
	public static void bubblesort(int[] linpdata) { 
		for(int i=0 ; i < linpdata.length ; i++) {
			for(int j=i ; j < linpdata.length ; j++) {
				if(linpdata[i] > linpdata[j]) {
					int temp = linpdata[i]; 
					linpdata[i] = linpdata[j];
					linpdata[j] = temp; 
				}
			}
		}
	}
}



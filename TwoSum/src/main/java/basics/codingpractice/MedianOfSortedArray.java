package basics.codingpractice;

public class MedianOfSortedArray {

	public static void main(String[] args) {
		int[] num1 = new int[] {1,3,5}; 
		int[] num2 = new int[] {2,4,6};
		int finallen = num1.length + num2.length;
		int midian=0; 
		boolean leven = false; 
		
		if(finallen > 1) {
			if(finallen % 2 == 0) {
				midian = finallen / 2; 
				leven = true; 
			}else
			{
				midian = (finallen-1) /2; 
			}
		}
		
		int[] numfinal = new int[num1.length + num2.length]; 
		int i=0, j=0, k=0; 
		
		while(i < num1.length) {
			while(j < num2.length) {
				if(num1[i] < num2[j]) { 
					numfinal[k] = num1[i]; 
					i++;
					k++; 
				}else 
				{				
					if(num1[i] > num2[j]) { 
						numfinal[k] = num2[j]; 
						j++; 
						k++; 
					}else
					{
						if(num1[i] == num2[j]) { 
							numfinal[k] = num1[i]; 
							i++;
							j++; 
							k++; 
						}
					}
				}
			}
			
			if(j == num2.length) {
				numfinal[k] = num1[i]; 
				i++;
				k++; 
			}
		}

		if(i == num1.length && j < num2.length) {
			while(j < num2.length) {
				numfinal[k] = num2[j]; 
				j++; 
				k++; 
			}
		}
		
		for(int l=0 ; l < numfinal.length ; l++) {
			if(leven == true) 
			{
				if(l == midian || l == midian+1 ) {
					System.out.println("M "+numfinal[l]);
				}else 
				{
					System.out.println(numfinal[l]); 
				}
			}else
			{
				if(l == midian) {
					System.out.println("M "+numfinal[l]);
				}else 
				{
					System.out.println(numfinal[l]); 
				}
			}
		}
	}

}

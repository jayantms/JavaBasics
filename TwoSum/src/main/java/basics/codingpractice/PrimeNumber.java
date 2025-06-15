package basics.codingpractice;

public class PrimeNumber {

	public static void main(String[] args) {

		int inpNumber = 24; 
		
		for(int i=2 ; i <= inpNumber ; i++) {
			if(checkPrime(i)) 
				System.out.println(i);
		}
	}
	
	
	public static boolean checkPrime(int num) {
		boolean lcheckPrime=true; 
		
		for(int i=2 ; i<num ; i++) {
			if(num % i == 0 && num != i) 
				lcheckPrime = false; 
		}
		
		return lcheckPrime; 
	}
}

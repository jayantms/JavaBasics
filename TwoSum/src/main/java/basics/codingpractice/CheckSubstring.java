package basics.codingpractice;

public class CheckSubstring {

	public static void main(String[] args) {
		String test1 = "AXY"; 
		String test2 = "YADXCP"; 

		checkSubstr(test1, test2); 
	}
	
	public static void checkSubstr(String test1, String test2) 
	{
		int i=0; 
		int j=0; 
		int lmatchStrCount = 0; 

		while ( i < test1.length() ) 
		{ 
			while ( j < test2.length() ) 
			{ 
				if(test1.charAt(i) == test2.charAt(j)) {
					System.out.println("Chars matched - "+test1.charAt(i)+" , "+test2.charAt(j)); 
					lmatchStrCount++;
					j++; 
					break; 
				}
				j++; 
			}
			
			i++; 
		}
		
		if(lmatchStrCount == test1.length()) {
			System.out.println("Sequence matched"); 
		}else {
			System.out.println("Sequence not-matched");
		}
	}
}

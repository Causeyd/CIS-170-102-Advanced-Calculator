
public class Calculator {//start class

	public static void main(String[] args) {//start main
		
		

	}//end main
	
	
	//Performs the rational roots test and returns an array of possible roots 
	//note, the test only works with integer coefficients and integer non-zero constant (the last number)
	//you still will get an answer, it will simple be nonsense as far as solving the problem is concerned
	public static int[] RationalRootsTest(int coefficent, int constant) {//begin rational roots test method
		
		//the first step is to get the factors of each number
		int[] coefficentFactors = Factors(coefficent);
		
		int[] constantFactors = Factors(constant);
		
		//this makes an array the size of the largest number of factors
		int[] roots = new int[Math.max(coefficentFactors.length, constantFactors.length)];
		
		//the rational roots are +/- the constantFactors/coeffiecentFactors
		//this for loop cycles through all combinations of constant and coefficient factors
		//p keeps track of which position we are in the roots array
		int p =0;
		for(int i = 0; i <constantFactors.length; i++) {//start outer for loop
			
			for(int n = 0; n < coefficentFactors.length; n++) {//start inner for loop
				
				roots[p] = constantFactors[i]/coefficentFactors[n];
				
				roots[p+1] = -constantFactors[i]/coefficentFactors[n];
				
				p += 2;
				
			}//end inner for loop
			
		}//end outer for loop
		
		
		return roots;
		
	}//end rational roots test method
	
	//UNFINISHED, this method will return a list of factors of the given integer
	public static int[] Factors(int number) {//start factors method
		
		int[] factors = new int[];
		
		return factors;
		
	}//end factors method
	
	
}//end class

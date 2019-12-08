
import java.util.ArrayList;

public class Calculator {//start class
	
	static ArrayList<Integer> answers = new ArrayList<Integer>();

	public static void main(String[] args) {//start main
		
		int[] tester = {1,2,1};
		
		int[] roots = RationalRootsTest(tester[0], tester[tester.length-1]);

		answer(tester, roots);
		
		String output;
		
		for(int i = 0; i < answers.size(); i++) {//start for print out answers
			
			if(answers.get(i) < 0) {//start if current answer is negative
				
				output = "(x - ";
				
			}//end if current answer is negative
			else {//start else answer is not negative
				
				output = "(x + ";
				
			}//end else answer is not negative
			
			output += answers.get(i) + ")";
			
			System.out.print(output);
			
		}//end for print out answers
		
	}//end main
	
	//this will take the possible roots and loop through them to find what is a root
	//if it finds one then the method will call itself with the newly discovered root factored out
	//that is because a polynomial may have multiple instances of the same root
	 public static void answer(int[] coefficients, int[]roots) {//start find answer
		 
		 //creates new array of same length as the coefficients of the equation
		 //this will be where we store the results of this attempt at synthetic division
		 int[] factored = new int[coefficients.length];
		 
		 if(coefficients.length <=2) {//start if is already completely factored
			 
			 return;
			 
		 }//end if is already completely factored
		 
		 //this integer will hold the value that we add to each term
		 int currentAdder;
		 
		 for(int i = 0; i< roots.length; i++) {//start for try all roots
			 
			 currentAdder = coefficients[0]*roots[i];
			 
			 factored[0] = coefficients[0];
			 
			 for(int n = 1; n < coefficients.length; n++) {//start for go through each coefficient except first one
				 
				 factored[n] = coefficients[n] + currentAdder;
				 
				 currentAdder = factored[n]*roots[i];
				 
			 }//end for go through each coefficient except first one
			 
			 //if this possible root is an answer the constant term will be zero
			 if(factored[factored.length-1] == 0) {//start if is answer
				 
				 answers.add(roots[i]);
				 
				 answer(factored, roots);
				 
				 return;
				 
			 }//end if is answer
			 
		 }//end for try all roots
		 
	 }//end find answer
	
	
	//Performs the rational roots test and returns an array of possible roots 
	//note, the test only works with integer coefficients and integer non-zero constant (the last number)
	//you still will get an answer, it will simple be nonsense as far as solving the problem is concerned
	public static int[] RationalRootsTest(int coefficient, int constant) {//begin rational roots test method
		
		//the first step is to get the factors of each number
		int[] coefficientFactors = Factors(coefficient);
		
		int[] constantFactors = Factors(constant);
		
		//this makes an array the size of the largest number of factors
		int[] roots = new int[Math.max(coefficientFactors.length, constantFactors.length)];
		
		System.out.println(coefficientFactors.length);
		
		System.out.println(constantFactors.length);
		
		
		//the rational roots are +/- the constantFactors/coeffiecentFactors
		//this for loop cycles through all combinations of constant and coefficient factors
		//p keeps track of which position we are in the roots array
		int p =0;
		for(int i = 0; i <constantFactors.length; i++) {//start outer for loop
			
			for(int n = 0; n < coefficientFactors.length; n++) {//start inner for loop
				
				roots[p] = constantFactors[i]/coefficientFactors[n];
				
				roots[p+1] = -constantFactors[i]/coefficientFactors[n];
				
				p += 2;
				
			}//end inner for loop
			
		}//end outer for loop
		
		
		return roots;
		
	}//end rational roots test method
	
	//This method will return a list of factors of the given integer
	public static int[] Factors(int number) {//start factors method
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		
		//looks at every value from 1 up to and including the number, if it divides evenly (% = 0) then it is a factor
		for(int i = 1; i <= number; i++) {//start find factors for loop
			
			if(number%i == 0){//start if i is a factor
				
				factors.add(i);
				
			}//end if i is a factor
			
		}//end find factors for loop
		
		//since I already wrote the Rational Roots Test to use an array I will convert it here
		int[] arrayFactors = new int[factors.size()];
		
		for(int n = 0; n < factors.size(); n++) {//start for convert to array
			
			arrayFactors[n] = factors.get(n);
			
		}//end for convert to array
		
		return arrayFactors;
		
	}//end factors method
	
	
}//end class

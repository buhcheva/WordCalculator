/**
 * WordCalc.java is a program that can translate 
 * a written with words number (less than one million)
 * to a digital number.
 * 
 * In case of a spelling mistake the user gets an error message.
 * 
 * General rules for writing numbers:
 *  - 25 is written as "twenty-five"
 *  - 105 is written as "one hundred five"
 *  However, the program accepts also "one hundred and five".
 *  - 356 721 is written as "three hundred fifty-six thousand seven hundred twenty-one"
 *  
 *  
 *  @file: WordCalc.java
 *  @author: Darina Buhcheva
 *  @date: 10/01/2013
 * 
 * 
 */


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.commons.lang.StringUtils;

public class WordCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		Scanner scanIn = new Scanner(System.in);
	
		System.out.println("Start calculator?[Y/N]");

		while (scanIn.hasNext() && (scanIn.nextLine().equalsIgnoreCase("y"))) {

			System.out.println("Enter a number in a string form: ");
			String stExpression = scanIn.nextLine();

			stringWork(stExpression);

			scanIn.nextLine();

		    System.out.println("Continue?[Y/N]");
		}
		
		scanIn.close();

	}
	
	/**
	 * Transforms the string keys into Integer values 
	 * 
	 * @param stNumber a key to a HashMap value
	 * @return the value from the HashMap
	 */
	
	public static int turnToInteger(String stNumber){
		
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
		
		map.put("zero", 0);
		map.put(null, 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		map.put("ten", 10);
		map.put("eleven", 11);
		map.put("twelve", 12);
		map.put("thirteen", 13);
		map.put("fourteen", 14);
		map.put("fifteen", 15);
		map.put("sixteen", 16);
		map.put("seventeen", 17);
		map.put("eighteen", 18);
		map.put("nineteen", 19);
		map.put("twenty", 20);
		map.put("thirty", 30);
		map.put("fourty", 40);
		map.put("fifty", 50);
		map.put("sixty", 60);
		map.put("seventy", 70);
		map.put("eighty", 80);
		map.put("ninety", 90);
		map.put("hundred", 100);
		map.put("thousand", 1000);
		
        if (map.containsKey(stNumber))
        {
        	return map.get(stNumber);
        } else {
        	return -1;
        }
			
		
	}
	
	/**
	 * Turns the string number into an integer
	 * 
	 * @param stNumber number in a string form
	 * @return finalNumber number as integer
	 */
	
	public static int stringWorkNumbers(String stNumber){
		int finalNumber = 0;
		int remainder = 0;
		
		// remove all hyphens from the string
		// e.g "twenty-one" will become "twenty one"
		stNumber = stNumber.replace("-", " ");

	
		// turn the string into an array taking " " as a character to separate
		String[] stArr = stNumber.split(" ");
		  
		 // remove all "and"-s in the sting, if any
		 List<String> list = new ArrayList<String>(Arrays.asList(stArr));
		 list.removeAll(Arrays.asList("and"));		 
		 String[] stArr1 = list.toArray(stArr);

		 for ( String ss : stArr1) {
			 
			   if (turnToInteger(ss) == 100) {
				   
				   remainder = finalNumber % 1000;				   
				   finalNumber += remainder * 100 - remainder;
				   
			   } else if (turnToInteger(ss) == 1000) {
				   
				   finalNumber *= 1000;
				   
			   } else if (turnToInteger(ss) == -1) {
				   
				   if (StringUtils.isNumeric(ss)) {
					   finalNumber += Integer.parseInt(ss);
				   } else {
			        System.out.println("The word '" + ss + "' is spelt wrongly.");
			        System.exit(-1);
				   }
   
		       } else{
				   
		           finalNumber += turnToInteger(ss);
		           
			   }
		  }
		
		return finalNumber;
	}
	
	/**
	 * Divides the entered string into smaller strings
	 * Finds the math operator and does the calculation
	 * 
	 * @param stExpression the string entered by the user
	 * @return result the result after the calculation has been carried out
	 * 
	 */
	
	public static void stringWork(String stExpression){
		String st1 = "";
		String st2 = "";
//		int result = 0;
		


		 // turn the string into an array taking " " as a character to separate
		 String[] stArr = stExpression.split(" ");
		 
		 for (int i=0; i<stArr.length; i++){
			 if (stArr[i].equals("minus") || stArr[i].equals("-")){
				 for (int j=0; j<=i-1; j++){
					 st1 += stArr[j] + " ";
				 }
				 for (int j=i+1; j<stArr.length; j++){
					 st2 += stArr[j] + " ";
				 }
				 System.out.println("Result: " + (stringWorkNumbers(st1) - stringWorkNumbers(st2)));

			 } else if (stArr[i].equals("plus") || stArr[i].equals("+")){
				 for (int j=0; j<=i-1; j++){
					 st1 += stArr[j] + " ";
				 }
				 for (int j=i+1; j<stArr.length; j++){
					 st2 += stArr[j] + " ";
				 }
				 System.out.println("Result: " + (stringWorkNumbers(st1) + stringWorkNumbers(st2)));
			 } else if (stArr[i].equals("multiplied") || stArr[i].equals("*")){
			     for (int j=0; j<=i-1; j++){
				     st1 += stArr[j] + " ";
			     }
			     for (int j=i+2; j<stArr.length; j++){
				     st2 += stArr[j] + " ";
			     }
			     System.out.println("Result: " + (stringWorkNumbers(st1) * stringWorkNumbers(st2)));
			     
			 } else if (stArr[i].equals("divided") || stArr[i].equals("/")) {
				 for (int j=0; j<=i-1; j++){
				     st1 += stArr[j] + " ";
			     }
			     for (int j=i+2; j<stArr.length; j++){
				     st2 += stArr[j] + " ";
			     }
			     System.out.format("Result: %.2f ", (float) stringWorkNumbers(st1) / stringWorkNumbers(st2));
			 }
		 }
		 
		// System.out.println(stringWorkNumbers(st1) + "  " + stringWorkNumbers(st2));
		// System.out.println(st1 + "   " + st2);
		
	}

}

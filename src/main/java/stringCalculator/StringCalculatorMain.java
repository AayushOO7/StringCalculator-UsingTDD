package stringCalculator;

import java.util.ArrayList;

public class StringCalculatorMain {
	
	public static int addNumbers(String numbers) {
		
		int finalResult = 0;
		if(numbers.isEmpty() || numbers == null) {
			finalResult = 0;
		}
		else if(numbers.startsWith("//[")) {    //Separate by single and/or multiple custom delimiter of any length.
			String delimiterList[] = getDelimiterList(numbers);
			numbers = numbers.substring(numbers.indexOf('\n')+1);
			numbers = extractNumberList(delimiterList, numbers);
			String stringNumberArray[] = numbers.split(",");
			finalResult = calculateSum(stringNumberArray);
		}
		else if(numbers.startsWith("//")) {    //Separate by single custom delimiter of length one.
			String delimiter = new String("");
			delimiter = numbers.substring(2, numbers.indexOf('\n'));
			if(delimiter.equals(".") || delimiter.equals("*")) {
				delimiter = "\\" + delimiter;
			}
			numbers = numbers.substring(numbers.indexOf('\n') + 1);
			String stringNumberArray[] = numbers.split(delimiter);
			finalResult = calculateSum(stringNumberArray);
		}
		else if(numbers.contains(",") || numbers.contains("\n")){ 
			String stringNumberArray[] = numbers.split("[,\n]");  
			finalResult = calculateSum(stringNumberArray);
		}
		else {
			finalResult = stringToInteger(numbers); 
		} 
		return finalResult;  //Return Final result as an integer value.
		
	}
	
	public static String[] getDelimiterList(String numbers) {
		
		ArrayList<String> delimiter = new ArrayList<String>();
		while(numbers.indexOf('[') != -1) {
			delimiter.add(numbers.substring(numbers.indexOf('[') + 1, numbers.indexOf(']')));
			numbers = numbers.substring(numbers.indexOf(']') + 1);
		}
		return delimiter.toArray(new String[0]);   //extract all delimiters from Input string.
		
	}

	public static String extractNumberList(String delimiterList[], String inputString) {
		
		String numberList = new String("");
		int index = 0;
		while(index < inputString.length()) {
			int delimiterLength = scanForExactDelimiterInInput(index, delimiterList, inputString);
			if(delimiterLength>0) {
				index = index + delimiterLength - 1;     //Skip Delimiter
			}
			else{
				numberList = numberList + inputString.charAt(index) + ",";     //Extract numbers(digits) from input string
			}
			index++;
		}
		return numberList;  //Return List of numbers from inputString
		
	}

	public static int scanForExactDelimiterInInput(int checkLocation, String[] delimiterList, String inputString) {
		
		int savedLocation = checkLocation;
		for(String delimiter:delimiterList) {
			int counter = 0, countElse=0;
			while(counter < delimiter.length()) {
				if(delimiter.charAt(counter) != inputString.charAt(checkLocation)) {
					break;
				}
				else {
					countElse++;
				}
				checkLocation++;
				counter++;
			}
			if(delimiter.length() == countElse) {
				return delimiter.length();
			}
			checkLocation = savedLocation;
		}
		return -1;
		
	}
	
	public static int calculateSum(String[] array) {
		
		int sum = 0;
		boolean isExceptionOccured = false;
		String negativeNumberList = new String("");
		int integerNumber = 0, arrayLength = array.length;
		for(int index = 0; index < arrayLength; index++) {
			integerNumber = stringToInteger(array[index]);
			if(integerNumber < 0) {
				negativeNumberList = negativeNumberList + integerNumber + ", ";
				isExceptionOccured = true;
			}
			sum = sum + integerNumber;     //add
		}
		if(isExceptionOccured) {    //If negative number exists then throw exception with list of Negative numbers present in Input.
			throw new IllegalArgumentException("Negatives Not Allowed: " + negativeNumberList);
		}
		else {    //If all numbers are positive then return sum.
			return sum;
		}
		
	}
	
	public static int stringToInteger(String stringValue) {
		
		if(stringValue.isEmpty()) {
			return 0;
		}
		int result = Integer.parseInt(stringValue);
		if(result > 1000) {   //Don't add if number is greater than 1000
			return 0;
		}
		else {
			return result;
		}
		
	}
	
}

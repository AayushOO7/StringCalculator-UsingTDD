package stringCalculator;

public class StringCalculatorMain {
	
	public static int addNumbers(String numbers) {
		
		int finalResult = 0;
		if(numbers.isEmpty() || numbers == null) {
			finalResult = 0;
		}
		else if(numbers.startsWith("//[")) {    //Separate by single custom delimiter of any length.
			String delimiter = getDelimiter(numbers);
			numbers = numbers.substring(numbers.indexOf('\n')+1);
			numbers = extractNumberList(delimiter, numbers);
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
		else if(numbers.contains(",")){ 
			String stringNumberArray[] = numbers.split("[,\n]");
			int arrayLength = stringNumberArray.length;
			int integerNumber = 0;
			for(int index = 0; index < arrayLength; index++) {
				integerNumber = stringToInteger(stringNumberArray[index]);
				finalResult = finalResult + integerNumber;
			}
		}
		else {
			finalResult = stringToInteger(numbers); 
		} 
		return finalResult;  //Return Final result as an integer value.
		
	}
	
	public static String getDelimiter(String numbers) {
		
		String delimiter = new String("");
		delimiter = numbers.substring(numbers.indexOf('[') + 1, numbers.indexOf('\n') - 1);
		return delimiter;   //extract delimiter from Input string.
		
	}

	public static String extractNumberList(String delimiter,String inputString) {
		
		String numberList = "";
		int index = 0;
		while(index < inputString.length()) {
			if(isExactDelimiterFoundInInput(index, delimiter, inputString)) {
				index = index + (delimiter.length());     //Skip Delimiter
			}
			else {
				numberList = numberList + inputString.charAt(index) + ",";     //Extract numbers(digits) from input string
				index++;
			}
		}
		return numberList;    //Return string with only numbers which are separated by comma(,).
		
	}

	public static boolean isExactDelimiterFoundInInput(int checkLocation, String delimiter, String inputString) {
		
		int counter = 0;
		while(counter < delimiter.length()) {
			if(delimiter.charAt(counter) != inputString.charAt(checkLocation)) {
				return false;    //Exact match of delimiter not found in Input.
			}
			checkLocation++;
			counter++;
		}
		return true;    //Exact match of delimiter found in Input.
		
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

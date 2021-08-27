package stringCalculator;

public class StringCalculatorMain {
	
	public static int addNumbers(String numbers) {
		
		int finalResult = 0;
		if(numbers.isEmpty() || numbers == null) {
			finalResult = 0;
		}
		else if(numbers.contains(",")){    //Add unknown amount of numbers which are present in Input.
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
	
	public static int stringToInteger(String stringValue) {
		
		int result = Integer.parseInt(stringValue);
		return result;
		
	}
	
}

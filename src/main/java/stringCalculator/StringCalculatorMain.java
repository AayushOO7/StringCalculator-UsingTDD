package stringCalculator;

public class StringCalculatorMain {
	
	public static int addNumbers(String numbers) {
		
		int finalResult = 0;
		if(numbers.isEmpty() || numbers == null) {
			finalResult = 0;
		}
		else if(numbers.contains(",")){    //Add two numbers which are present in Input.
			String stringNumberArray[] = numbers.split(",");
			int firstNumber = stringToInteger(stringNumberArray[0]);
			int secondNumber = stringToInteger(stringNumberArray[1]);
			finalResult = firstNumber + secondNumber;
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

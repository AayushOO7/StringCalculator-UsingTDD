package stringCalculator;

public class StringCalculatorMain {
	
	public static int addNumbers(String numbers) {
		
		int finalResult = 0;
		if(numbers.isEmpty() || numbers == null) {
			finalResult = 0;
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
	
	public static int calculateSum(String[] array) {
		int sum = 0;
		int integerNumber=0, arrayLength = array.length;
		for(int index = 0; index < arrayLength; index++) {
			integerNumber = stringToInteger(array[index]);
			sum = sum + integerNumber;
		}
		return sum;
	}
	
	public static int stringToInteger(String stringValue) {
		
		int result = Integer.parseInt(stringValue);
		return result;
		
	}
	
}

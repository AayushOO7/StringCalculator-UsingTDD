package stringCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class StringCalculatorJunitTest {

	private int expectedResult, actualResult;

	@Before   
	public void initializeData() {   //This function will run before all the TestCases.
		expectedResult = 0;
		actualResult = 0;
	}
	
	@Test
	void checkForEmptyString() {    //Check when String contains empty String
		String input = new String("");
		expectedResult = 0;
		actualResult = StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return 0 for an Empty String");
	}
	
	@Test
	void checkForOneNumber() {    //Check when string contains only one number in it.
		String input = new String("5");
		expectedResult = 5;
		actualResult = StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return same value as input String");
	}

	@Test
	void checkForTwoNumbers() {    //Check when string contains two numbers in it, separated by comma(,).
		String input=new String("5,7");
		expectedResult=12;
		actualResult=StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of two numbers which are given as input String");
	}
	
	@Test
	void checkForMultipleNumbers() {    //Check when string contains unknown amount of numbers, separated by comma(,).
		String input = new String("5,7,5,3,4,1");
		expectedResult = 25;
		actualResult = StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String");
	}
	
	@Test
	void shouldAcceptNewLineDelimiter() {    //Check when string contains numbers separated by comma(,) and/or new line(\n).
		String input = new String("5\n7\n5,3,4\n1,10");
		expectedResult = 35;
		actualResult = StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String and accpet new line delimiter");
	}
	
	@Test
	void shouldAcceptSingleCustomDelimiter() {    //Check when string contains numbers separated by a single custom delimiter of length one.
		String input = new String("//;\n1;4");
		expectedResult = 5;
		actualResult = StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String separated by a single custom delimiter");
	}
	
	@Test
	void shouldAcceptDotAsCustomDelimiter() {    //Check when string contains numbers separated by dot(.) as a single custom delimiter.
		String input = new String("//.\n1.4.5");
		expectedResult = 10;
		actualResult = StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String separated by Dot as a single custom delimiter");
	}
	
	@Test
	void checkForNegativeNumbers() {    //Check, when string contains negative numbers is it throwing exception.
		String input = new String("//.\n1.-4.-5.10.23.-54.-767.-77");
		assertThrows(IllegalArgumentException.class, () -> {
			StringCalculatorMain.addNumbers(input);
		});
	}
	
	@Test
	void shouldIgnoreNumbersGreaterThanThousand() {    //Check when string contains numbers greater than 1000.
		String input = new String("//.\n1.4.5.1000.1001.100012.23232.999");
		expectedResult = 2009;
		actualResult = StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Ignore number(s) greater than 1000 and eturn sum of numbers present in input String");
	}
	
	@Test
	void shouldAcceptAnyLengthCustomDelimiter() {    //Check when string contains numbers separated by a single custom delimiter of any length.
		String input = new String("//[***]\n1***4***3***2***5");
		expectedResult = 15;
		actualResult = StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String separated by a single custom delimiter of any length");
	}
	
	@Test
	void shouldAcceptMultipleCustomDelimiter() {    //Check when string contains numbers separated by Multiple custom delimiter of length one.
		String input=new String("//[*][%][;]\n1*4%3*2%5;5");
		expectedResult=20;
		actualResult=StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String separated by Multiple custom delimiter of length one");
	}
	
	@Test
	void shouldAcceptAnyLengthMultipleCustomDelimiter() {    //Check when string contains numbers separated by Multiple custom delimiter of Any Length.
		String input=new String("//[****][%%][;;]\n1****4%%3****2%%5;;5%%5;;5");
		expectedResult=30;
		actualResult=StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String separated by Multiple custom delimiter of Any Length");
	}

}

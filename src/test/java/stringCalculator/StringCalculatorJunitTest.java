package stringCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class StringCalculatorJunitTest {

	private int expectedResult, actualResult;

	@Before   
	public void initializeData() {   //This function will run before all the TestCases.
		expectedResult=0;
		actualResult=0;
	}
	
	@Test
	void checkForEmptyString() {    //Check when String contains empty String
		String input=new String("");
		expectedResult=0;
		actualResult=StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return 0 for an Empty String");
	}
	
	@Test
	void checkForOneNumber() {    //Check when string contains only one number in it.
		String input=new String("5");
		expectedResult=5;
		actualResult=StringCalculatorMain.addNumbers(input);
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
		String input=new String("5,7,5,3,4,1");
		expectedResult=25;
		actualResult=StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String");
	}
	
	@Test
	void shouldAcceptNewLineDelimiter() {    //Check when string contains numbers separated by comma(,) and/or new line(\n).
		String input=new String("5\n7\n5,3,4\n1,10");
		expectedResult=35;
		actualResult=StringCalculatorMain.addNumbers(input);
		assertEquals(expectedResult, actualResult, "Should return sum of all numbers present in input String and accpet new line delimiter");
	}

}

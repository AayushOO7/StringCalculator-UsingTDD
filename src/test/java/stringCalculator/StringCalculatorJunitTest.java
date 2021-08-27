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
	void initialTest() {
		
	}

}


# String Calculator using TDD in JAVA

**Name : Aayush Solanki** <br/>
**Branch : CSE** <br/>
**College : Nirma University** <br/>

## Description 
This repository contains the implementation of task mentioned at [osherove.com/tdd-kata-1](https://osherove.com/tdd-kata-1). This program is developed in JAVA Language using Test Driven Development Approach with the help of JUnit5. 

## Implementation
To perform unit testing, I've used Java's **JUnit5 Testing Framework** which is used to write and run repeatable automated tests. JUnit provides annotations to identify test methods. I have created test cases in StringCalculatorJunitTest.java to incorporate unit testing for string calculator.

Here I have used org.junit pacakage, which contains interfaces and classes which we will need to perform unit testing, it provides some useful methods & classes like assertEqual, Assert and it also provides some annotations like @Before, @Test.

Repository contains one folder [src](src/), which contains two sub-folders, [main](src/main/java/stringCalculator) folder consists logic for calculator's add function and the [test](src/test/java/stringCalculator) folder consists of test cases which are used to test this program.

## Files
- [StringCalculatorMain.java](src/main/java/stringCalculator/StringCalculatorMain.java) : this file contains logic for add method of the string calculator
- [StringCalculatorJunitTest.java](src/test/java/stringCalculator/StringCalculatorJunitTest.java) : this file contains test cases to be test the logic of [StringCalculatorMain.java](src/main/java/stringCalculator/StringCalculatorMain.java) file

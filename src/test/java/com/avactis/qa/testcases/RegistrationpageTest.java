package com.avactis.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.qa.base.TestBase;
import com.avactis.qa.pages.RegistrationPage;

public class RegistrationpageTest extends TestBase {

	RegistrationPage register;
	
	public RegistrationpageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		initialization();
		register = new RegistrationPage();

	}

	@AfterMethod
	public void afterMethod() {

	}
	
	@Test
  public void registrationTest(){
		
		register.userRegistration("hemant@gmail.com", "1234567", "1234567", "hemant", "pandey", "India", "Chhattisgarh", "497557", "Chirimiri", "XYX", "abcD", "7987169412");
	}
}

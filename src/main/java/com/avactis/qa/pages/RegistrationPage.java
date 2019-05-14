package com.avactis.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import com.avactis.qa.base.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(linkText = "Sign In")
	private WebElement signInLink;

	@FindBy(xpath = "//div/a/button[@class='btn btn-default']")
	private WebElement registrationLink;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Email]']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Password]']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='customer_info[Customer][RePassword]']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='customer_info[Customer][FirstName]']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='customer_info[Customer][LastName]']")
	private WebElement lastName;

	@FindBy(xpath = "//select[@id='customer_info_Customer_Country']")
	private WebElement countryName;

	@FindBy(xpath = "//select[@name='customer_info[Customer][State]']")
	private WebElement selectState;

	@FindBy(xpath = "//input[@name='customer_info[Customer][ZipCode]']")
	private WebElement postalCode;

	@FindBy(xpath = "//input[@name='customer_info[Customer][City]']")
	private WebElement enterCity;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Streetline1]']")
	private WebElement streetLine;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Streetline2]']")
	private WebElement streetLine2;

	@FindBy(xpath = "//input[@name='customer_info[Customer][Phone]']")
	private WebElement contactNumber;

	@FindBy(xpath = "//input[@class='en btn btn-primary btn-register input_submit']")
	private WebElement registrationButton;

	@FindBy(xpath = "//span/span//a[text()='Sign Out']")
	private WebElement signOut;

	//private WebDriver driver;

	public RegistrationPage() {

		PageFactory.initElements(driver, this);

	}

	public void userRegistration(String email, String pass, String conPass,
			String fName, String lName, String country, String state,
			String zipCode, String city, String addLine1, String addLine2,
			String conNumber) {

		signInLink.click();
		registrationLink.click();
		emailAddress.sendKeys(email);
		password.sendKeys(pass);
		confirmPassword.sendKeys(conPass);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);

		Select preferredCountry = new Select(countryName);

		for (WebElement oneState : preferredCountry.getOptions()) {

			if (oneState.getText().equals(country)) {
				oneState.click();
				break;
			}

		}

		Select preferredState = new Select(selectState);

		for (WebElement oneState : preferredState.getOptions()) {

			if (oneState.getText().equals(state)) {
				oneState.click();
				break;
			}

		}

		postalCode.sendKeys(zipCode);
		enterCity.sendKeys(city);
		streetLine.sendKeys(addLine1);
		streetLine2.sendKeys(addLine2);
		contactNumber.sendKeys(conNumber);
		registrationButton.click();
		signOut.click();

	}

}

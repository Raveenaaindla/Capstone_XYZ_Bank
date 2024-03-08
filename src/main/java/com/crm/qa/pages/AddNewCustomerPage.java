package com.crm.qa.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.TestBase.TestBase;



public class AddNewCustomerPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//button[normalize-space()='Add Customer']")
	WebElement AddCustomer_button;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement Customer_Name;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement Customer_LastName;
	
	@FindBy(xpath="//input[@placeholder='Post Code']")
	WebElement Post_code;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
	
	
	//Initializing the Page Objects:
	public AddNewCustomerPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	// Method to get the title of the login page.
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	// Method to retrieve text from an alert dialog.
	public String getAlertMessageText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
        
    }
	
	// Method to accept the alert dialog.
	public void getAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
    }

	
	// Method to add a new customer.
	public AddNewCustomerPage AddCustomer(String fname,String Lname,String postcode)
	{
		AddCustomer_button.click();
		Customer_Name.clear();
		Customer_Name.sendKeys(String.valueOf(fname));
		Customer_LastName.clear();
		Customer_LastName.sendKeys(String.valueOf(Lname));
		Post_code.clear();
		Post_code.sendKeys(String.valueOf(postcode));
		Submit.click();  
		return new AddNewCustomerPage();
	}
	
	// Method to assert if actual text contains expected partial text.
	public static void assertContains(String actualText, String expectedPartialText) {
        Assert.assertTrue(actualText.contains(expectedPartialText), "Actual text does not contain expected partial text");
    }
	
}
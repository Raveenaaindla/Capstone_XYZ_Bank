package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.TestBase.TestBase;

public class BankManagerPage extends TestBase {
	@FindBy(xpath="//button[normalize-space()='Bank Manager Login']")
	WebElement Manager_Login;
	
	
	//Initializing the Page Objects:
	public BankManagerPage() throws IOException {
	    PageFactory.initElements(driver, this);
	}

	
	// Action to validate the title of the login page
	public String validateLoginPageTitle(){
		return driver.getTitle();
	
	}
		
	// Action to perform Bank Manager login
	public AddNewCustomerPage ManagerLogin()
	{
		Manager_Login.click();
		return new AddNewCustomerPage();
	}



    // Placeholder for Bank Manager login action with additional parameters
	public AmountWithdrawalPage BankManagerLogin1(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
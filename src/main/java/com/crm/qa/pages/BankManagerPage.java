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

	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	
	}
		
	public AddNewCustomerPage ManagerLogin()
	{
		Manager_Login.click();
		return new AddNewCustomerPage();
	}


	public AmountWithdrawalPage BankManagerLogin1(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
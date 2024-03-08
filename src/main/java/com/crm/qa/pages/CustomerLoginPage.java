package com.crm.qa.pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.TestBase.TestBase;


public class CustomerLoginPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath="//button[normalize-space()='Customer Login']")
	WebElement Customer_Login;
	
	@FindBy(xpath="//button[normalize-space()='Bank Manager Login']")
	WebElement Manager_Login;
	
	
	
	//Initializing the Page Objects:
	public CustomerLoginPage() throws IOException {
	    PageFactory.initElements(driver, this);
	}

	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public AmountWithdrawalPage CustomerLogin(String username)
	{
		Customer_Login.click();
		WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText(username);
        String path=prop.getProperty("Login");
        
        driver.findElement(By.xpath(path)).click();
        
        return new AmountWithdrawalPage();

		
	}
	
	public TransactionViewPage CustomerLogin1(String username)
	{
		Customer_Login.click();
		WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText(username);
        String path=prop.getProperty("Login");
        
        driver.findElement(By.xpath(path)).click();
        
        return new TransactionViewPage();

		
	}
	
	
	public AddNewCustomerPage ManagerLogin()
	{
		Manager_Login.click();
		return new AddNewCustomerPage();
	}
	public OpenNewAccountPage ManagerLogin1()
	{
		Manager_Login.click();
		return new OpenNewAccountPage();
	}
	public CustomersDetailsPage ManagerLogin2()
	{
		Manager_Login.click();
		return new CustomersDetailsPage();
	}


	


	
	


	
}
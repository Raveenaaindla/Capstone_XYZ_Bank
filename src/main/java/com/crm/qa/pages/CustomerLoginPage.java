package com.crm.qa.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.crm.qa.TestBase.TestBase;

public class CustomerLoginPage extends TestBase {
	
	// Page Factory elements for Customer Login and Bank Manager Login buttons
	@FindBy(xpath="//button[normalize-space()='Customer Login']")
	WebElement CustomerLogin;
	
	@FindBy(xpath="//button[normalize-space()='Bank Manager Login']")
	WebElement ManagerLogin;
	
	
	
	//Initializing the Page Objects:
	public CustomerLoginPage() throws IOException {
	    PageFactory.initElements(driver, this);
	}

	
	// Action to validate the title of the login page
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public AmountWithdrawalPage CustomerLogin(String username)
	{
		CustomerLogin.click();
		WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText(username);
        String path=prop.getProperty("Login");
        
        driver.findElement(By.xpath(path)).click();
        
        return new AmountWithdrawalPage();

		
	}
	
	// Action to perform Customer Login
	public TransactionViewPage CustomerLogin1(String username)
	{
		CustomerLogin.click();
		WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText(username);
        String path=prop.getProperty("Login");
        
        driver.findElement(By.xpath(path)).click();
        
        return new TransactionViewPage();

		
	}
	
	// Action to perform Bank Manager Login
	public AddNewCustomerPage ManagerLogin()
	{
		ManagerLogin.click();
		return new AddNewCustomerPage();
	}
	public OpenNewAccountPage ManagerLogin1()
	{
		ManagerLogin.click();
		return new OpenNewAccountPage();
	}
	public CustomersDetailsPage ManagerLogin2()
	{
		ManagerLogin.click();
		return new CustomersDetailsPage();
	}	
}
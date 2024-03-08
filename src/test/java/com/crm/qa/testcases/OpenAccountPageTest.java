package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.CustomerLoginPage;
import com.crm.qa.pages.OpenNewAccountPage;

public class OpenAccountPageTest extends TestBase{
	CustomerLoginPage loginPage;
	OpenNewAccountPage openAccountPage;
	
	// Retrieve username for opening account from properties
	String OpenAccount_username = prop.getProperty("OpenAccount_username");
		
	public OpenAccountPageTest()
	{
		super();
	}	
	
	@BeforeMethod
	public void setUp() {
		
		// Initialize test environment
		initialization();
		try {
			
			// Initialize login page object
			loginPage = new CustomerLoginPage();
			
		} catch (IOException e) {
			
			// Handle IO Exception
			e.printStackTrace();
			
		}
		
		// Login as manager
		openAccountPage = loginPage.ManagerLogin1();
		
		
		
	}
	
	@Test(priority=1)
	public void OpenAccount() throws InterruptedException{
		
		// Click on the button to open an account
		openAccountPage.OpenAccount_button.click();
		
		// Add customer for opening account
		openAccountPage.AddCustomer(OpenAccount_username);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		// Quit the WebDriver after test execution
		driver.quit();
	}
	
	
	
	

}
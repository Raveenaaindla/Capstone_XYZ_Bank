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
	String OpenAccount_username = prop.getProperty("OpenAccount_username");
		
	public OpenAccountPageTest()
	{
		super();
	}	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		try {
			loginPage = new CustomerLoginPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openAccountPage = loginPage.ManagerLogin1();
		
		
		
	}
	
	@Test(priority=1)
	public void OpenAccount() throws InterruptedException{
		openAccountPage.OpenAccount_button.click();
		openAccountPage.AddCustomer(OpenAccount_username);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
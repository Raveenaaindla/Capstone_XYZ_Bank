package com.crm.qa.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.TransactionViewPage;
import com.crm.qa.pages.CustomerLoginPage;

public class CustomerTransactionPageTest extends TestBase{
	CustomerLoginPage loginPage;
	TransactionViewPage customerTransactionPage;
	
	// Properties to store dates and user account information
	String date = prop.getProperty("ValidationDate");
	String Startdate = prop.getProperty("StartDate");
	String Enddate = prop.getProperty("EndDate");	
	String AccountexistUser = prop.getProperty("AccontExistUser");
	
	
	// Constructor to initialize the test class
	public CustomerTransactionPageTest()
	{
		super();
	}
	
	
	// Method to setup test environment before each test method
	@BeforeMethod
	public void setUp() {
		initialization();
		try {
			loginPage = new CustomerLoginPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Logging in as customer and getting the transaction page
		customerTransactionPage = loginPage.CustomerLogin1(AccountexistUser);
		
		
	}
	
	// Test method to verify deposit with valid amount
	@Test(priority=1)
	public void Verify_Deposit_With_ValideAmmount()
	{
		 // Filtering transactions within given dates
		customerTransactionPage.Filter(Startdate, Enddate);
		
	}
	
	// Method to teardown the environment after each test method	
	@AfterMethod
	public void tearDown(){
		// Quitting the driver
		driver.quit();
	}
	
	
	
	

}
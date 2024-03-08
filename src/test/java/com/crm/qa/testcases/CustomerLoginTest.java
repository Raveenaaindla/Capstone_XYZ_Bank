package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.AmountWithdrawalPage;
import com.crm.qa.pages.CustomerLoginPage;



public class CustomerLoginTest extends TestBase{
	CustomerLoginPage loginPage;
	AmountWithdrawalPage accountPage;
	String AccountexistUser = prop.getProperty("AccontExistUser");
	String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");
	
	
	// Constructor
	public CustomerLoginTest(){
		super();
	}
	
	// Method to execute before each test method
	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		loginPage = new CustomerLoginPage();
		accountPage = new AmountWithdrawalPage();
		
	}
	
	// Test method for customer login
	@Test(priority=1)
	public void customerlogin()
	{
		loginPage.CustomerLogin(AccountexistUser);
		String name=accountPage.verifyCustomerName();
		AssertJUnit.assertEquals(AccountexistUser,name);	
	}

	// Method to execute after each test method
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
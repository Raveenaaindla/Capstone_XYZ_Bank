package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.AmountWithdrawalPage;
import com.crm.qa.pages.AddNewCustomerPage;
import com.crm.qa.pages.BankManagerPage;

public class BankManagerNavigationPageTest extends TestBase {
	BankManagerPage bankManagerPage;

	public BankManagerNavigationPageTest() {
		super();
	}

	// Method to set up test environment before each test case
	@BeforeMethod
	public void setUp() {
		// Initialize the test environment
		initialization();
		try {
			// Initialize BankManagerPage object
			bankManagerPage = new BankManagerPage();
		} catch (IOException e) {
			// Handle IOException
			e.printStackTrace();
		}
	}

	// Test method to verify Bank Manager login functionality
	@Test
	public void testBankManagerLogin() {
		
		// Perform Bank Manager Login
		// Attempt to log in as Bank Manager
		AddNewCustomerPage accountPage = bankManagerPage.ManagerLogin();
		try {
			Thread.sleep(3000); // 3 seconds sleep
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Assertions
		Assert.assertNotNull(accountPage, "Bank Manager Login failed or did not navigate to the expected page.");
		// Add more assertions based on the expected behavior after Bank Manager Login
	}

	// Method to tear down the test environment after each test case
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

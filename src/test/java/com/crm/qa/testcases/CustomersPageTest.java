package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.CustomersDetailsPage;
import com.crm.qa.pages.CustomerLoginPage;

public class CustomersPageTest extends TestBase {
	CustomerLoginPage loginPage;
	CustomersDetailsPage customersPage;
	String Customers_username = prop.getProperty("Customers_username");

	public CustomersPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		// Initialize the WebDriver
		initialization();

		try {
			// Instantiate LoginPage
			loginPage = new CustomerLoginPage();
		} catch (IOException e) {

			// Print stack trace if an exception occurs during instantiation
			e.printStackTrace();

		}

		// Login as a manager and navigate to customer details page
		customersPage = loginPage.ManagerLogin2();
	}

	@Test(priority = 1)
	public void DeleteCustomerEntry() throws InterruptedException {

		// Delete customer entry using the username
		customersPage.DeleteEntry(Customers_username);

	}

	@AfterMethod
	public void tearDown() {
		// Close the WebDriver session
		driver.quit();
	}

}
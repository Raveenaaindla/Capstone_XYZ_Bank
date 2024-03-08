package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.TestBase.TestBase;



public class AmountWithdrawalPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//span[@class='fontBig ng-binding']")
	WebElement Customer_Name;
	
	@FindBy(xpath="//button[@ng-click='deposit()']")
	WebElement Deposit_button;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
	@FindBy(xpath="//button[normalize-space()='Withdrawl']")
	WebElement Withdraw_button;
	
	@FindBy(xpath="//div[2]/strong[1]")
	WebElement Account_number;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[2]/strong[2]") ////div[2]/strong[2]
	WebElement Balance;

	@FindBy(xpath="//div[2]/strong[3]")
	WebElement Currency;
	
	@FindBy(xpath="//select[@id='accountSelect']")
	WebElement AccountNumberList;
	
	@FindBy(xpath="//input[@placeholder='amount']")
	WebElement Amount_Filed;
	
	@FindBy(xpath="//span[@class='error ng-binding']")
	WebElement Message;
	
	
	
	//Initializing the Page Objects:
	public AmountWithdrawalPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	// Method to get the title of the login page.
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	// Method to verify customer name.
	public String verifyCustomerName(){
		return Customer_Name.getText();
	}
	
	// Method to get the balance amount.
	public String GetBalance()
	{
		return Balance.getText();
	}
	
	// Method to get the count of account numbers.
	public int acno()
	{
	 Select dropdown = new Select(AccountNumberList);
	  int itemCount = dropdown.getOptions().size();
	  return itemCount; 
	}
	
	// Method to select account by index.
	public void SelectAccount(int index)
	{
		 Select dropdown = new Select(AccountNumberList);
		 dropdown.selectByIndex(index);
	}
	
	// Method to perform deposit action.
	public AmountWithdrawalPage Deposit(int amount)
	{
		Deposit_button.click();
		 Amount_Filed.clear();
		 Amount_Filed.sendKeys(String.valueOf(amount));
		Submit.click();  	
		return new AmountWithdrawalPage();
	}
	
	// Method to perform withdrawal action.
	public AmountWithdrawalPage Withdraw(int amount) throws InterruptedException
	{
		
		Withdraw_button.click();
		Wait();
		Amount_Filed.clear();
		Wait();
		Amount_Filed.sendKeys(String.valueOf(amount));
		Wait();
		Submit.click();  

		return new AmountWithdrawalPage();
	}
	
	// Method to get message.
	public String message()
	{
		return Message.getText();
	}
	
	// Method to calculate current balance after deposit.
	public int DepositCurrentBalance(int Amount_To_Deposit,int oldBalance)
	{
		int currentBalance = 0;
		if(Amount_To_Deposit < 0)
		{
			currentBalance = oldBalance;
		}
		else
		{
			currentBalance = oldBalance + Amount_To_Deposit;
		}
		return currentBalance;
		
	}
	
	// Method to calculate current balance after withdrawal.
	public int WithdrawCurrentBalance(int Amount_To_Withdraw,int oldBalance)
	{
		int currentBalance = 0;
		if(Amount_To_Withdraw < 0 || Amount_To_Withdraw > oldBalance)
		{
			currentBalance = oldBalance;
		}
		else
		{
			currentBalance = oldBalance - Amount_To_Withdraw;
		}
		return currentBalance;
		
	}
	

    // Method to perform valid deposit.
	public void ValidDeposit(String message,int Amount)
	{
		int count = acno();
		for(int i=0;i<count;i++)
		{
			 SelectAccount(i);
			 int oldBal= Integer.valueOf(GetBalance());
			 Deposit(Amount);
			 int newBal = Integer.valueOf(GetBalance());
			 int currentBal = DepositCurrentBalance(Amount,oldBal) ;
			 Assert.assertEquals(currentBal, newBal);
			 String msg = message();
			 Assert.assertEquals(msg , message );
			 
		}
	}
	
	// Method to perform invalid deposit.
	public void InValidDeposit(int Amount)
	{
		int count = acno();
		for(int i=0;i<count;i++)
		{
			 SelectAccount(i);
			 int oldBal= Integer.valueOf(GetBalance());
			 Deposit(Amount);
			 int newBal = Integer.valueOf(GetBalance());
			 int currentBal = DepositCurrentBalance(Amount,oldBal) ;
			 Assert.assertEquals(currentBal, newBal);
			 
			
			 
		}
	}
	

    // Method to perform valid withdrawal.
	public void ValidWithdraw(String message,int Amount) throws InterruptedException
	{
		int count = acno();
		for(int i=0;i<count;i++)
		{
			 SelectAccount(i);
			 Deposit(20000);
			 int oldBal= Integer.valueOf(GetBalance());
			 Withdraw(Amount);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 int newBal = Integer.valueOf(GetBalance());
			 int currentBal = WithdrawCurrentBalance(Amount,oldBal) ;
			 Assert.assertEquals(currentBal, newBal);
			 String msg = message();
			 Assert.assertEquals(msg , message );
			 
		}
	}
	
	// Method to perform invalid withdrawal.
	public void Wait() throws InterruptedException {Thread.sleep(1000);}
	public void InValidWithdraw(int Amount) throws InterruptedException
	{
		int count = acno();
		for(int i=0;i<count;i++)
		{
			 SelectAccount(i);
			 int oldBal= Integer.valueOf(GetBalance());
			 Withdraw(Amount);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 int newBal = Integer.valueOf(GetBalance());
			 int currentBal = WithdrawCurrentBalance(Amount,oldBal) ;
			 Assert.assertEquals(newBal,currentBal);
			 
			 
		}
	}

	// Method to navigate to withdrawal page.
	public AmountWithdrawalPage navigateToWithdrawalPage1() {
		// TODO Auto-generated method stub
		return null;
	}

	// Method to click withdrawal tab.
	public void clickWithdrawlTab() {
		// TODO Auto-generated method stub
		
	}

	// Method to enter withdrawal amount
	public void enterWithdrawlAmount(String string) {
		// TODO Auto-generated method stub
		
	}

	// Method to click withdrawal button.
	public void clickWithdrawlButton() {
		// TODO Auto-generated method stub
		
	}

	// Method to get error message.
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	// Method to get withdrawal success message.
	public String getWithdarwlSuccessMSG() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
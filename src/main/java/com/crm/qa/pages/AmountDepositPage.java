package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.TestBase.TestBase;

public class AmountDepositPage extends TestBase {

	// Web elements
    @FindBy(xpath="//button[@ng-click='deposit()']")
    private WebElement depositButton;

    @FindBy(xpath="//input[@placeholder='amount']")
    private WebElement amountField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath="//span[@class='error ng-binding']")
    private WebElement message;

    // Constructor to initialize the page objects
    public AmountDepositPage() {
        PageFactory.initElements(driver, this);
    }
    
   // Method to enter deposit amount into the amount field
    public void enterDepositAmount(int amount) {
        amountField.clear();
        amountField.sendKeys(String.valueOf(amount));
    }

 // Method to submit the deposit
    public void submitDeposit() {
        submitButton.click();
    }

 // Method to perform deposit action with a given amount
    public void depositAmount(int amount) {
        depositButton.click();
        amountField.clear();
        amountField.sendKeys(String.valueOf(amount));
        submitButton.click();
    }

 // Method to get the message displayed after deposit action
    public String getMessage() {
        return message.getText();
    
	}

	
}

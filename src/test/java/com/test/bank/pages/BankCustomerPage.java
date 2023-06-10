package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankCustomerPage {

    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#userSelect")
    WebElement yourName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div//strong[contains(text(),' Welcome ')]")
    WebElement welcomeMessage;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDepositAndWithdrawButton;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessful;

    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawlButton;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement transactionSuccessful;

    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement balance;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionsButton;


    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement amountDeposit;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement amountWithdrawal;

    public void loginFunctionality(String customerName,String expectedWelcomeMessage){
        BrowserUtils.selectBy(yourName, customerName, "text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage), expectedWelcomeMessage);


    }

    public void depositFunctionality(String depositAmount,String expectedDepositSuccessful){

        depositButton.click();
        amount.sendKeys(depositAmount);
        submitDepositAndWithdrawButton.click();

        Assert.assertEquals(BrowserUtils.getText(depositSuccessful), expectedDepositSuccessful);

    }

    public void withdrawalFunctionality( String withdrawalAmount,String expectedTransactionSuccessful) throws InterruptedException {

        withdrawlButton.click();
        Thread.sleep(2000);
        amount.sendKeys(withdrawalAmount);

        this.submitDepositAndWithdrawButton.click();

        Assert.assertEquals(BrowserUtils.getText(transactionSuccessful), expectedTransactionSuccessful);



    }

    public void transactionFunctionality() throws InterruptedException {

        int actualBalance=Integer.parseInt(BrowserUtils.getText(balance));//200
        Thread.sleep(2000);

        transactionsButton.click();

        int expectedBalance = (Integer.parseInt(BrowserUtils.getText(amountDeposit) )-
                Integer.parseInt(BrowserUtils.getText(amountWithdrawal)));

        Assert.assertEquals(actualBalance,expectedBalance);




    }


}





















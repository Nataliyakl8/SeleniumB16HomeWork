package com.test.openchart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenChartCustomerPage {

    public OpenChartCustomerPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//i[@class='fas fa-plus']")
    WebElement addButton;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@name='confirm']")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='newsletter']")
    WebElement newsLetter;

    @FindBy(xpath = "//input[@name='status']")
    WebElement status;

    @FindBy(xpath = "//input[@name='safe']")
    WebElement safe;

    @FindBy(xpath = "//i[@class='fas fa-save']")
    WebElement save;

    @FindBy(xpath = "//div[@id='alert']")
    WebElement warningMsg;

    public void customerPageAddInfo(String name, String lastN,String Email,String passcode,String passcodeConfirm){

        addButton.click();

        firstName.sendKeys(name);
        lastName.sendKeys(lastN);
        email.sendKeys(Email);
        password.sendKeys(passcode);
        confirmPassword.sendKeys(passcodeConfirm);



    }
    public void customerPageSelectOthers(WebDriver driver){


        if(newsLetter.isDisplayed()&& ! newsLetter.isSelected()&&newsLetter.isEnabled()){

            BrowserUtils.clickWithJS(driver,newsLetter);}




       if(status.isDisplayed()&& !status.isSelected()&& status.isEnabled()){

           BrowserUtils.clickWithJS(driver,status);}

       if(safe.isDisplayed()&&!safe.isSelected()&& safe.isEnabled()){
            BrowserUtils.clickWithJS(driver,safe);}

           save.click();


    }

   public void message(String expectedMsg){

       Assert.assertEquals(BrowserUtils.getText(warningMsg),expectedMsg);
   }



}

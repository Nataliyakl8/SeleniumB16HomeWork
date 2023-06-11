package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazePlaceOrderPage {

    public BlazePlaceOrderPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement cCard;

    @FindBy(css = "#month")
    WebElement expMonth;

    @FindBy(css = "#year")
    WebElement expYear;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement confirmMsg;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;



    public void fillOutOrder(String nameCustomer,String countryCustomer,String cityCustomer,String card,String month,String year ){

        this.name.sendKeys(nameCustomer);
        this.country.sendKeys(countryCustomer);
        this.city.sendKeys(cityCustomer);
        this.cCard.sendKeys(card);
        this.expMonth.sendKeys(month );
        this.expYear.sendKeys(year);

        purchaseButton.click();

    }

   public void confirmPurchase(String expectedMsg){

       Assert.assertEquals(BrowserUtils.getText(confirmMsg),expectedMsg);
       okButton.click();


   }

}

package com.test.blaze.pages;

import Utils.BrowserUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {

    public BlazeCartPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".success")
    List <WebElement> cartItems;

    @FindBy(css=".btn-success")
    WebElement placeOrder;

    public void cartItemsList(String expectedTitle, String expectedPrice){

        List <String> expectedItemsInCart= Arrays.asList("",expectedTitle,expectedPrice,"");


        for (int i = 1; i < cartItems.size()-1; i++) {

            Assert.assertEquals(BrowserUtils.getText(cartItems.get(i)),expectedItemsInCart.get(i));

        }
    }

    public void clickPlaceOrder() throws InterruptedException {

        placeOrder.click();

        Thread.sleep(2000);
    }
}

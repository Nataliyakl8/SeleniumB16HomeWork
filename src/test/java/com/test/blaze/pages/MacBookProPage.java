package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage {

    public MacBookProPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(tagName = "h3")
    WebElement laptopPrice;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addToCart;



    public void macBookPageInformation(String expectedHeader,String expectedPrice, String expectedDescription){

        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);

        Assert.assertEquals(BrowserUtils.getText(laptopPrice),expectedPrice);

        Assert.assertEquals(BrowserUtils.getText(description),expectedDescription);

    }

    public void clickAddToCart(WebDriver driver ,String expectedAlertText) throws InterruptedException {

        addToCart.click();

        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();

        Assert.assertEquals((alert.getText()),expectedAlertText);

        alert.accept();


    }
}

package com.test.blaze.tests;

import com.test.bank.tests.BankTestBase;
import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MacBookProPageTest extends BlazeTestBase {

    @Test

    public void validationMacBookProPageInfo () throws InterruptedException {

        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);

        blazeHomePage.selectCategory("Laptops");

        LaptopPage laptopPage=new LaptopPage(driver);

        laptopPage.selectLaptop("MacBook Pro");

        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.macBookPageInformation("MacBook Pro","$1100 *includes tax","Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");

        macBookProPage.clickAddToCart(driver,"Product added");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/prod.html?idp_=15#");





    }
}

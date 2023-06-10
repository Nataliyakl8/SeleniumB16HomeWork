package com.test.openchart.pages;

import com.test.openchart.tests.OpenChartLogin;
import com.test.openchart.tests.OpenChartTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase {

    @Test

    public void validateLoginFunctionality() throws InterruptedException {

        OpenChartLogin openChartLogin=new OpenChartLogin(driver);

        openChartLogin.loginFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle(),"Dashboard");

    }


    @Test
    public void validateNegativeLoginFunctionality() throws InterruptedException {
        OpenChartLogin openChartLogin=new OpenChartLogin(driver);
        openChartLogin.loginFunctionality("demo","demo8");

        Assert.assertEquals(openChartLogin.errorMessage(),"No match for Username and/or Password.");



    }


}

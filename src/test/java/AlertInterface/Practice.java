package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {

    @Test
    public void practiceJSAlert() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement click1= driver.findElement(By.cssSelector("#alertBox"));
        click1.click();

        Alert alert=driver.switchTo().alert();

        String actualMsg= alert.getText().trim();
        String expectedMsg="I am an alert box!";

        Assert.assertEquals(actualMsg,expectedMsg);

        alert.accept();

        WebElement msgAfter= driver.findElement(By.xpath("//div[contains(@id,'output')]"));
        String actualMsgAfter= BrowserUtils.getText(msgAfter);
        String expectedMsgAfter="You selected alert popup";
        Assert.assertEquals(actualMsgAfter,expectedMsgAfter);

        WebElement click2= driver.findElement(By.cssSelector("#confirmBox"));
        click2.click();

        driver.switchTo().alert();

        String actualMsg2=alert.getText().trim();
        String expectedMsg2="Press a button!";

        Assert.assertEquals(actualMsg2,expectedMsg2);

        alert.dismiss();

        WebElement msgAfter2= driver.findElement(By.cssSelector("#output"));
        String actualMsgAfter2= BrowserUtils.getText(msgAfter);
        String expectedMsgAfter2="You pressed Cancel in confirmation popup";
        Assert.assertEquals(actualMsgAfter2,expectedMsgAfter2);

        WebElement click3= driver.findElement(By.cssSelector("#promptBox"));
        click3.click();

        driver.switchTo().alert();

        alert.sendKeys("Nataliya");

        alert.accept();

        WebElement msgAfter3= driver.findElement(By.cssSelector("#output"));

        String actual=BrowserUtils.getText(msgAfter3);
        String expected="You entered text Nataliya in propmt  popup";

        Assert.assertEquals(actual,expected);


    }


}
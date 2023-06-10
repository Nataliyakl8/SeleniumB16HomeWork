package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSPractice {

    @Test
    public void JSPractice() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement radioButton= driver.findElement(By.cssSelector("#yesRadio"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",radioButton);

      //  radioButton.click();--if not working --we use Actions class .
       // Actions actions =new Actions(driver);
     //  actions.click().perform(); ---> if Actions not working we use JAva Script

        WebElement msgYes=driver.findElement(By.cssSelector(".mt-3"));

        String actualMsg = BrowserUtils.getText(msgYes);
        String expectedMsg="You have selected Yes";
        Assert.assertEquals(actualMsg,expectedMsg);

        WebElement radioButton2 =driver.findElement(By.cssSelector("#impressiveRadio"));

        js.executeScript("arguments[0].click()",radioButton2);
       // radioButton2.click();

        WebElement mstImpress= driver.findElement(By.cssSelector(".mt-3"));

        String actualMsg2 = BrowserUtils.getText(mstImpress);
        String expectedMsg2="You have selected Impressive";
        Assert.assertEquals(actualMsg2,expectedMsg2);

        WebElement noButton= driver.findElement(By.cssSelector("#noRadio"));
          Assert.assertFalse(noButton.isEnabled());














    }
}
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

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSAlert= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        JSAlert.click();

        Alert alert=driver.switchTo().alert();

        String actualText=alert.getText().trim();//i will get text from POP up that i cannot inspect
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);

        alert.accept();//will click OK button

        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualMsg= BrowserUtils.getText(message);
        String expectedMsg="You successfully clicked an alert";

        Assert.assertEquals(actualMsg,expectedMsg);


    }

    @Test
    public void alertDismiss(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement JSConfirm= driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        JSConfirm.click();

        Alert alert=driver.switchTo().alert();
        alert.dismiss();

        WebElement msg= driver.findElement(By.xpath("//p[contains(@id,'result')]"));

        String actualMsg=BrowserUtils.getText(msg);
        String expectedMsg="You clicked: Cancel";
        Assert.assertEquals(actualMsg,expectedMsg);



    }

         @Test
         public void alertSendKeys(){
             WebDriverManager.chromedriver().setup();
             ChromeOptions options = new ChromeOptions();
             options.addArguments("--remote -allow-origins=*");
             WebDriver driver=new ChromeDriver(options);
             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
             driver.get("https://the-internet.herokuapp.com/javascript_alerts");

             WebElement jsPrompt= driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
             jsPrompt.click();

             Alert alert=driver.switchTo().alert();
             alert.sendKeys("Homework is important");

             alert.accept();

             WebElement msg= driver.findElement(By.cssSelector("#result"));
             String actualMsg=BrowserUtils.getText(msg);
             String expectedMSg="You entered: Homework is important";

             Assert.assertEquals(actualMsg,expectedMSg);
         }
}
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

public class HTMLandJSPractice {

    @Test
    public void practiceBoth() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");
                                ////h5[contains(text(),'Normal alert')]//..//button  --> other option from parent
        WebElement preview1= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        preview1.click();

        Alert alert=driver.switchTo().alert();

        String actual= alert.getText().trim();
        String expected="Oops, something went wrong!";
        Assert.assertEquals(actual,expected);

        alert.accept();

        WebElement preview2= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        preview2.click();
        Thread.sleep(2000);

        /* WebElement oopsMSg= driver.findElement(By.xpath("//div[contains(text(),'Oops')]"));
        System.out.println(BrowserUtils.getText(oopsMSg));
        WebElement msgText= driver.findElement(By.xpath("//div[contains(text(),'Something went wrong!')]"));
        System.out.println(BrowserUtils.getText(msgText));*/

        WebElement all = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        String actualMsg=BrowserUtils.getText(all);
        String expectedMsg="Something went wrong!";
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        System.out.println(BrowserUtils.getText(all));

        Thread.sleep(2000);
                                                                       //button[.='OK']
        WebElement okButton= driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        okButton.click();

        driver.quit();


    }
}
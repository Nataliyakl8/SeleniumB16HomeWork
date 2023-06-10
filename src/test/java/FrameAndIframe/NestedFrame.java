package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void NestedFramePractice() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");

        WebElement iFrameLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iFrameLeft);

        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));

        System.out.println(BrowserUtils.getText(left));

        driver.switchTo().parentFrame();//top frame
        driver.switchTo().frame("frame-middle");

        WebElement middle = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(middle));

        driver.switchTo().parentFrame();//top frame
        driver.switchTo().frame("frame-right");

        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));

        //SHORTCUT --> no need to count parents frame --just go to main default Frame !!!
        driver.switchTo().defaultContent();
       // driver.switchTo().parentFrame();//top frame
      //  driver.switchTo().parentFrame();//main HTML

        driver.switchTo().frame("frame-bottom");//Bottom frame

        //switching frame with index
        // driver.switchTo().frame(1);--BOTTOm frame -- by INDEX  --but not recommended

        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));

        System.out.println(BrowserUtils.getText(bottom));



    }
}

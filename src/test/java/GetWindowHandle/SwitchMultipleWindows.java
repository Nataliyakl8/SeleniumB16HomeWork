package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {

    @Test

    public void SwitchPractice(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPageId=driver.getWindowHandle();
         Set< String> allPageID = driver.getWindowHandles();

         for(String id: allPageID){

             if(!id.equals(mainPageId)){
                 driver.switchTo().window(id);
                 break;
             }
         }
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver,"Contact");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


        BrowserUtils.switchByTitle(driver,"Kickstart");

        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver,"Courses");

        System.out.println(driver.getTitle());


}
@Test

    public void realTask(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote -allow-origins=*");
    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

    /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */

    WebElement button4= driver.findElement(By.cssSelector("#newTabsBtn"));
    button4.click();

    BrowserUtils.switchByTitle(driver,"Basic Controls");

    WebElement firstNAme= driver.findElement(By.cssSelector("#firstName"));
    firstNAme.sendKeys("Nataliya");

    WebElement lastName= driver.findElement(By.cssSelector("#lastName"));
    lastName.sendKeys("Kl");

    WebElement gender= driver.findElement(By.cssSelector("#femalerb"));
    gender.click();

    WebElement language= driver.findElement(By.cssSelector("#englishchbx"));
    language.click();

    WebElement email= driver.findElement(By.cssSelector("#email"));
    email.sendKeys("mail@mail.com");

    WebElement password= driver.findElement(By.cssSelector("#password"));
    password.sendKeys("qwerty");

    WebElement register=driver.findElement(By.cssSelector("#registerbtn"));
    register.click();

    WebElement message=driver.findElement(By.cssSelector("#msg"));

    String actualMsg= BrowserUtils.getText(message);
    String expectedMsg="Registration is Successful";

    Assert.assertEquals(actualMsg,expectedMsg);

    BrowserUtils.switchByTitle(driver,"Window");

    WebElement header= driver.findElement(By.xpath("//h1[@itemprop='name']"));

    String actualHeader=BrowserUtils.getText(header);
    String expectedHeader="Window Handles Practice";

    Assert.assertEquals(actualHeader,expectedHeader);

    BrowserUtils.switchByTitle(driver,"AlertsDemo");

    WebElement clickMe=driver.findElement(By.cssSelector("#promptBox"));
    clickMe.click();

    driver.quit();


}


}

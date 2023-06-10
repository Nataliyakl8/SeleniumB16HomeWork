package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {

        /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver drive = new ChromeDriver(options);
        drive.manage().window().maximize();
        drive.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = drive.findElement(By.name("firstname"));
        firstName.sendKeys("Nataliya");

       WebElement lastName = drive.findElement(By.name("lastname"));
       lastName.sendKeys("Klymyuk");


       WebElement type = drive.findElement(By.id("sex-1"));
       type.click();

       WebElement exp = drive.findElement(By.id("exp-5"));
       exp.click();

        Thread.sleep(3000);
       WebElement date = drive.findElement(By.id("datepicker"));
       date.sendKeys("05/16/2023");


        Thread.sleep(3000);
       WebElement profession1 = drive.findElement(By.id("profession-1"));
       profession1.click();

        Thread.sleep(3000);

       WebElement tools = drive.findElement(By.id("tool-2"));
       tools.click();

       WebElement continent = drive.findElement(By.id("continents"));
       continent.sendKeys("Asia");

       Thread.sleep(3000);

       WebElement button = drive.findElement(By.id("submit"));
       button.click();

       String url ="https://www.techlistic.com/p/selenium-practice-form.html";

        System.out.println(drive.getCurrentUrl().equals(url)? "  good": " not ok ");

        drive.quit();


    }
}

package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");


        ChromeDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/natal/Downloads/Techtorial.html");

        //LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));

        javaLink.click();

        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";

        System.out.println(actualHeader.equals(expectedHeader)?" correct": "false");
         driver.navigate().back();
//========================================================================================
        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();

        WebElement seleniumHeader= driver.findElement(By.tagName("h1"));

        String headerA = seleniumHeader.getText().trim();
        String headerE ="Selenium automates browsers. That's it!";

        System.out.println(headerA.equals(headerE)? "yes good": "no not ok ");

        driver.navigate().back();
//-------------------------------------------------------------------------------

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();

        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));

        String headerAC= cucumberHeader.getText().trim();
        String headerEC="Tools & techniques that elevate teams to greatness";

        System.out.println(headerAC.equals(headerEC)? "good ": "not good");

        driver.navigate().back();

        //------------------------------------------------------------------------------

        WebElement testNgLink = driver.findElement(By.linkText("TestNG"));
        testNgLink.click();

        WebElement testHeader = driver.findElement(By.tagName("h2"));

        String headerTestA = testHeader.getText().trim();
        String headerTestE = "TestNG";

        System.out.println(headerTestA.equals(headerTestE)? "ok":"not ok");

        driver.navigate().back();

//-------------------------------------------------------------------------------------------

      driver.getCurrentUrl();

      String url= "file:///C:/Users/natal/Downloads/Techtorial.html";

        System.out.println(driver.getCurrentUrl().equals(url)? "all :)  good": "nooooo");

      // Locator partial linkText

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());


    }
}

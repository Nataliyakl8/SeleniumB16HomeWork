package SeleniumLocators;

import com.google.j2objc.annotations.Weak;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    //locators --ia a way to locate/find element and manipulate
    public static void main(String[] args) throws InterruptedException {

        //ID locator:

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("file:///C:/Users/natal/Downloads/Techtorial.html");

        driver.manage().window().maximize();

        WebElement header = driver.findElement(By.id ("techtorial1"));

        String actualHeader = header.getText().trim();// it gets the text from element

        String expectedHeader ="Techtorial Academy";

        System.out.println(header.getText());

        System.out.println(actualHeader.equals(expectedHeader)? "correct": "wrong");


        WebElement text = driver.findElement(By.id("details2"));

        System.out.println(text.getText());


        //NAME LOCATOR:

        WebElement firstName= driver.findElement(By.name("firstName"));

        firstName.sendKeys("Nataliya");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Klymyuk");

        WebElement phone = driver.findElement(By.name("phone"));

        phone.sendKeys("789456123");

        WebElement email = driver.findElement(By.id("userName"));// Id is more accurate --more secure
        email.sendKeys("mail@mali.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("2655 Smith st ");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement zip = driver.findElement(By.name("postalCode"));
        zip.sendKeys("60634");


      // CLASS LOCATOR:

        WebElement allTools = driver.findElement(By.className("group_checkbox"));

        System.out.println(allTools.getText());

       WebElement javaBox = driver.findElement(By.id("cond1"));

       if(javaBox.isDisplayed()&& !javaBox.isSelected()){

           javaBox.click();
       }
        System.out.println(javaBox.isDisplayed()?"Selected":"Not selected");


       WebElement testNg = driver.findElement(By.id("cond3"));

       if(testNg.isDisplayed() && !testNg.isSelected()){

           testNg.click();
       }

        System.out.println(testNg.isDisplayed()?"Selected" : "not selected ");

       WebElement cucumber  = driver.findElement(By.id("cond4"));

        if(cucumber.isDisplayed()&&!cucumber.isSelected()){

            cucumber.click();
        }
        System.out.println(cucumber.isDisplayed()? "yes": "no");


        //TAG NAME LOCATOR

        WebElement header2= driver.findElement(By.tagName("h1"));

        System.out.println(header2.getText());

        WebElement javaVersion  = driver.findElement(By.tagName("u"));

        System.out.println(javaVersion.getText());

        Thread.sleep(2000);

        driver.quit();





    }
}

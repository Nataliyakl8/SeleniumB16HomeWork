package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHRealHealthProject {

      /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
           */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

      //  WebElement makeApp = driver.findElement(By.xpath("//a[.='Make Appointment']"));
     //   makeApp.click();

        //CSS with ID--> #

        WebElement makeAppointment = driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppointment.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.id("btn-login"));
        login.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("HongKong");

        WebElement box = driver.findElement(By.name("hospital_readmission"));
        box.click();

        WebElement program= driver.findElement(By.id("radio_program_medicaid"));
        program.click();


        WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("18/05/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("it it very important ");

       // WebElement book = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));

        // CSS with  CLASS --> . dot used

        WebElement button= driver.findElement(By.cssSelector(".btn-default"));
        button.click();

        WebElement header = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String expectedHeader="Appointment Confirmation";
        if(header.equals(expectedHeader)){

            System.out.println(header.getText());
        }

        WebElement text1= driver.findElement(By.xpath("//p[.='Hongkong CURA Healthcare Center']"));
        System.out.println(text1.getText());

        WebElement text2= driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        System.out.println(text2.getText());

        WebElement text3= driver.findElement(By.xpath("//p[contains(text(),'Medicaid')]"));
        System.out.println(text3.getText());

        WebElement text4= driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(text4.getText());

        WebElement text5= driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(text5.getText());

        WebElement home = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        home.click();

        System.out.println(driver.getCurrentUrl());

        driver.quit();









    }
}

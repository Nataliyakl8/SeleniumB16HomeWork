package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver drive = new ChromeDriver(options);
        drive.manage().window().maximize();
        drive.navigate().to("https://demoqa.com/text-box");

        WebElement userName = drive.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Nataliya Klymyuk");



        WebElement email= drive.findElement(By.xpath("//input[@id='userEmail']"));
         email.sendKeys("mail@mail.com");

         WebElement currentAdd = drive.findElement(By.xpath("//textarea[@id='currentAddress']"));
         currentAdd.sendKeys("3465 Lonsdale rd., Prospect heights, IL 60070");


        WebElement permanentAdd = drive.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAdd.sendKeys("308 Willow rd., Arlington heights, IL 60070");

        WebElement button=drive.findElement(By.xpath("//button[.='Submit']"));
        button.click();

        WebElement userNameDisp= drive.findElement(By.xpath("//p[@id='name']"));
        String displayedName =userNameDisp.getText();
        String expectedName ="Nataliya Klymyuk";

        if(displayedName.contains(expectedName)){
            System.out.println(displayedName);

        }
        WebElement emailDisp= drive.findElement(By.xpath("//p[@id='email']"));
        String displayedEmail =emailDisp.getText();
        String expectedEmail ="mail@mail.com";

        if(displayedEmail.contains(expectedEmail)){
            System.out.println(displayedEmail);
        }

        WebElement currentAddDisp =drive.findElement(By.xpath("//p[@id='currentAddress']"));
        String displayedCurr=currentAddDisp.getText();
        String expectedCurr="3465 Lonsdale rd., Prospect heights, IL 60070";

        if(displayedCurr.contains(expectedCurr)){
            System.out.println(displayedCurr);
        }

        Thread.sleep(3000);

        WebElement permanentAddDisp =drive.findElement(By.xpath("//p[@id='permanentAddress']"));
        String displayedPerm = permanentAddDisp.getText().trim();
        String expectedPerm ="308 Willow rd., Arlington heights, IL 60070";

        System.out.println(displayedPerm.contains(expectedPerm)? displayedPerm: "failed");

       drive.quit();




    }
}

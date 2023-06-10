package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Nataliya");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Kly");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("3948878944@mail.com");

        WebElement tel = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        tel.sendKeys("773-996-0561");

        WebElement passcode = driver.findElement(By.xpath("//input[@id='input-password']"));
        passcode.sendKeys("12@123@");

        WebElement passcodeConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passcodeConfirm.sendKeys("12@123@");

        WebElement box = driver.findElement(By.xpath("//input[@name='agree']"));
        box.click();

        WebElement continuE = driver.findElement(By.xpath("//input[@value='Continue']"));
        continuE.click();

        WebElement header1=driver.findElement(By.xpath("//h1[.='Your Account Has Been Created!']"));
        String expectedHeader="Your Account Has Been Created!";     // better //h1[contains(text(),'Has Been Created')]-->!!!
        System.out.println(header1.getText().trim().equals(expectedHeader)?"header ok": "header not ok ");

        WebElement continue2= driver.findElement(By.xpath("//a[.='Continue']"));
        continue2.click();


       String url="https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(driver.getCurrentUrl().equals(url)? "it is correct": "not correct");

       driver.quit();








    }
}

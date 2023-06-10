package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile= driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\natal\\OneDrive\\Desktop\\usa_720.png");


        WebElement uploadButton= driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();
       // uploadButton.submit(); <form> tag name ; type =" submit" ,

        WebElement uploaded=driver.findElement(By.cssSelector("#uploaded-files"));

        String actual = BrowserUtils.getText(uploaded);
        String expected="usa_720.png";

        Assert.assertEquals(actual,expected);


    }

    @Test
    public void practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement chooseFile= driver.findElement(By.cssSelector(".upload_txt"));

        chooseFile.sendKeys("C:\\Users\\natal\\OneDrive\\Desktop\\usa_720.png");

        WebElement textBelow= driver.findElement(By.xpath("//b[contains(text(),'Select file to send(max 196.45 MB)')]"));

        String actual=BrowserUtils.getText(textBelow);
        String expected="Select file to send(max 196.45 MB)";

        Assert.assertEquals(actual,expected);

        WebElement checkBox=driver.findElement(By.cssSelector("#terms"));

        if(checkBox.isDisplayed()&&!checkBox.isSelected()&&checkBox.isEnabled()){
            checkBox.click();
        }

        WebElement submit= driver.findElement(By.cssSelector("#submitbutton"));
        submit.click();
        Thread.sleep(2000);
        WebElement text2=driver.findElement(By.xpath("//h3//center"));//

        String actualText=BrowserUtils.getText(text2);
        String expectedText="1 file\n" +
                "has been successfully uploaded.";
        Thread.sleep(2000);
        Assert.assertEquals(actualText,expectedText);


}}

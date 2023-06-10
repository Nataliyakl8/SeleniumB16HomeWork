package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();//set up
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");


        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait time
        driver.get("https://the-internet.herokuapp.com/");//url

        int count=0;
        //List<WebElement> elementsLinks =driver.findElements(By.xpath("//ul"));--> works too--because UL just 1
       List<WebElement> elements=driver.findElements(By.xpath("//li"));//li--repeats 44 times

        for (WebElement link:elements){

            //System.out.println(link.getText() );
            //task --print if length == or more than 12

            if(link.getText().length()>=12){

                System.out.println(link.getText() );
                count++;
            }

        }
        System.out.println(count);


    }
}

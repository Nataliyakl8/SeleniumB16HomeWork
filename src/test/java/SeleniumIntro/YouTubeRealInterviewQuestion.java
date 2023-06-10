package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.modes.KCCMBlockCipher;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();//set up
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");


        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait time
        driver.get("https://www.youtube.com/");//url
        //Thread.sleep(2000)
        // song.sendKeys(Keys.Arrow_down)

        WebElement search= driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Imagine dragons");
        search.sendKeys(Keys.ENTER);

         // one more command --Keys.Enter --no need to find button element
        //  WebElement button= driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        //  button.click();
         Thread.sleep(2000);// if scroll down --use .sleep --more time to search /load elements
        List<WebElement> songs =driver.findElements(By.xpath("//a[@id='video-title']"));

        for(WebElement song:songs){
                                        //"title" --equals " Song name "
            if(song.getAttribute("aria-label").contains("Imagine Dragons - Believer")){
                Thread.sleep(2000);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();
                break;

            }
        }




    }
}

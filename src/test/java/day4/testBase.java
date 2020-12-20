package day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Random;

public class testBase {

 protected  WebDriver driver;

    @BeforeMethod
    public void setup(){
        // WebDriverManager.chromedriver().setup(); //automatycznie pobiera odpowiednia wersje drivera nie pypisujemy sciezki i nie dodajemy pliku chromedriver z import github
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extensions");
        driver = new ChromeDriver(options);

    }
    @AfterMethod // ta kropka spowalnia wykonywanie testu w przegladarce
    public void tearDown(){
        driver.quit();
    }

    public WebElement getRandomElement(List<WebElement> elements){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size() - 1);
        return elements.get(randomNumber);
    }


    public int getRandomNumber(int max){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt()+1;
        return randomNumber;
    }
 void veryBadSleep(){
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            e.printStackTrace();

     }
 }
}

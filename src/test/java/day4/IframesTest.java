package day4;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTest extends  testBase{

    @BeforeMethod
    public void openIframesPage(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
    }

    @Test
    public void iFrameTest(){
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.id("inputSurname3")).sendKeys("Kowalski");

        driver.switchTo().defaultContent();// powrót na str glowna

        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("Jan_Kowalski");
        driver.findElement(By.id("inputPassword")).sendKeys("WQEQWDsadSF");

        Select selectContinents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));// lista wyboru to select
        selectContinents.selectByVisibleText("Europe");

        WebElement radioExpirience = driver.findElement(By.id("gridRadios7"));
        radioExpirience.click();
    }

}


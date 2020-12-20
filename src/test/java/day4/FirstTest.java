package day4;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FirstTest extends testBase {
protected WebDriver driver;




    @Test
    public void fromTest(){

        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Adam");

        WebElement lastName= driver.findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");

        WebElement email = driver.findElement(By.id("inputEmail3"));
        email.sendKeys("ada.kowalski@mail.com");


        WebElement sex = driver.findElement(By.cssSelector("input[value='male']"));
        sex.click();

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        sex.sendKeys("44");

        List<WebElement> yearsOfExperience = driver.findElements(By.name("gridRadiosExperience"));
        getRandomElement(yearsOfExperience).click();

        WebElement commandsElement = driver.findElement(By.id("selectSeleniumCommands"));
        Select commandSelect = new Select(commandsElement);// wybor elementu
        //commandSelect.selectByValue("browser-commands");
        List<WebElement> commandsOptions = commandSelect.getOptions();
        int howManyOption = getRandomNumber(commandsOptions.size());
        for(int i=0; i< howManyOption; i++){
            commandSelect.selectByIndex(i);
        }


        //wybor losowego elenemtu
    WebElement continentsElements = driver.findElement(By.id("selectContinents"));
    Select continents = new Select(continentsElements);
    List<WebElement> continentsOptions = continents.getOptions();//wyciagniecie listy , pobranie opcji
        continentsOptions.remove(0); //usunięcie pierwszego elementu z lity choose
    WebElement randomOption = getRandomElement(continentsOptions);//wybranie losowej opcji
    continents.selectByVisibleText(randomOption.getText());// wybrana opcje wybieramy z niej tekst

    WebElement fileInput = driver.findElement(By.id("chooseFile"));
    File file = new File("src/main/resources/test.txt");
    fileInput.sendKeys(file.getAbsolutePath());

        WebElement additionalInformations = driver.findElement(By.id("additionalInformations"));
        additionalInformations.sendKeys("to jest test");

        WebElement signIn = driver.findElement(By.cssSelector(".btn-primary")); // button ma 2 klasy, w css wypisujemy tylko 1 lub button[type='submit']
        signIn.click();

        String validationMessage = driver.findElement(By.id("validator-message")).getText();

        Assert.assertEquals(validationMessage,"Form send with success");


        }

}

package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class selectable extends testBase{

    @BeforeMethod
    public void openIframesPage(){
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
    }

    @Test
    public void selectableTest(){

        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content")); // wybieramy 6 elementow
       int index = getRandomNumber(items.size()-1);
        items.get(index).click();

        Assert.assertEquals(driver.findElement(By.id("select-result")).getText(),"0"+index);
    }

    @Test
    public void shouldSelectItem(){
        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)// klikniecie przycisku myszy
                .click(items.get(3))// zaznaczenie elementu 3 z tabeli liczymy od 0
                .click(items.get(4))
                .click(items.get(0))
                .keyUp(Keys.LEFT_CONTROL)// puszczenie przycisku
                .build()// pzechowanie elementu
                .perform();//wyswietlenie

        Assert.assertEquals(driver.findElement(By.id("select-result")).getText(),"#1 #4 #5");// o 1 wieksze bo to nie tabela
    }
}

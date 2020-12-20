package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class dropable extends testBase {

    private WebElement drag;
    private WebElement drop;
    private Actions actions;

    @BeforeMethod
    public void openIframesPage(){
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        drag = driver.findElement(By.cssSelector("#droppable"));
        drop = driver.findElement(By.cssSelector("#droppable"));
        actions = new Actions(driver);
    }

    @Test
    public void dropableTest(){
        actions.dragAndDrop(drag, drop)
        .perform();

    }
@Test
public void clickAndHoldTest(){
        actions.clickAndHold(drag)// wybierz i przeciagnij
                .release(drop)// upusc w miejscu
                .perform();
}
    @Test
    public void holdMoveandDropTest() {
        actions.clickAndHold(drag)// wybierz i przeciagnij
                .moveToElement(drop)// upusc w miejscu
                .release()
                        .perform();
    }

    @Test
    public void dragandDropbyoffTest() {
        int x1 =drag.getLocation().getX();// pobierz lokacje elementu
        int y1 = drag.getLocation().getY();

        int x2 =drop.getLocation().getX();// upusc w miejscu- offsety
        int y2 = drop.getLocation().getY();

        actions.dragAndDropBy(drag, x2 -x1, y2 - y1)
        .perform();

    }


    @AfterMethod
    public void verify(){
        Assert.assertEquals(drop.getText(), "Dropped!");
    }
}

package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Datapicker extends testBase{

   // WebElement driver;
    @BeforeMethod
    public void openDatapickerPage() {
        driver.get("https://seleniumui.moderntester.pl/datapicker.php");

    }

    @Test
    public void calendarTest(){
        //;
        selectDate("13", "October", 2020);
        Assert.assertEquals(getSelectedDate(), "13/10/2020");
    }

    private void selectDate(String expectedDay, String expectedMonth, int expectedYear){

    }

    private String getSelectedDate(){
        return driver.findElement(By.id("datepicker")).getText();
    }

    public String getMonth(){
        return driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();

    }
    public int getYear(){
        return Integer.parseInt(driver.findElement(By.cssSelector(".ui-datepicker-year")).getText());

    }
    public void goNext(String expectedMonth, int expectedYear){
        while(!expectedMonth.equals(getMonth()) || expectedYear != getYear()){
            driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
            veryBadSleep();
        }

    }
    public void goPrev(String expectedMonth, int expectedYear) {
        while (!expectedMonth.equals(getMonth()) || expectedYear != getYear()) {
            driver.findElement(By.cssSelector(".ui-datepicker-prev")).click();
            veryBadSleep();
        }
    }
}
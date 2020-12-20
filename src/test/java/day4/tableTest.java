package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class tableTest extends testBase {

    @BeforeMethod
    public void openTable() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

    }

    @Test
    public void tableTest() {
        List<WebElement> mountainRows = driver.findElements(By.cssSelector("tbody>tr"));
        List<Moutain> mountains = new ArrayList<>();

        for(WebElement element : mountainRows){
    mountains.add(new Moutain(element));
}
        for (Moutain moutain : mountains){
            if(moutain.getHight()> 4500 && moutain.getState().contains("SwitzerLand")){
                System.out.println(moutain.toString());
            }
        }
    }
}
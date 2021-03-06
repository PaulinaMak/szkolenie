package day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPO extends BasePO {
    //click "delayed alert"
    //wait for allert
    // close alert
    //assert text

    @FindBy(id="delayed-alert")
    private WebElement delayedAlert;

    @FindBy(id="delayed-alert-label")
    private WebElement delayedAlertLabel;

    public AlertPO clickDelayedAlert(){

        delayedAlert.click();
        return this;
    }

    public String getDelayedalertLabelText(){
        return delayedAlertLabel.getText();

    }

    public AlertPO waitForAlertAndAccept(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }





    public AlertPO(WebDriver driver) {
        super(driver);
        ownURL = "https://seleniumui.moderntester.pl/alerts.php";
    }
}

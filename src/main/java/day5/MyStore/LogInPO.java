package day5.MyStore;

import day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPO extends BasePO {
    @FindBy(css = "[data-link-action=\"display-register-form\"]")
    private WebElement createAccountLink;

    public void clickCreateAccountLink(){
        createAccountLink.click();
    }



    public LogInPO(WebDriver driver) {
        super(driver);
        ownURL = "http://5.196.7.235/login";
    }
}
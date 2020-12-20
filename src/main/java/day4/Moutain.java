package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Moutain {
    private String name;
    private int hight;
    private String state;

    public Moutain(WebElement row) {
        List<WebElement> partsOfRow = row.findElements(By.cssSelector("td"));//razbicie tablicy na obiekty
        this.name = partsOfRow.get(0).getText();// wybranie kolumny
        this.hight = Integer.parseInt(partsOfRow.get(3).getText());
        this.state = partsOfRow.get(2).getText();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Moutain{" +
                "name='" + name + '\'' +
                ", hight=" + hight +
                ", state='" + state + '\'' +
                '}';
    }
}

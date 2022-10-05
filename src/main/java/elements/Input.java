package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static drivers.WebDriverManager.getDriver;

public class Input extends BaseElement {
    public Input(By xPath, String nameElement) {
        super(xPath, nameElement);
    }

    public WebElement getElement() {
        return getDriver().findElement(xPath);
    }

    public void sendKeys(CharSequence... keysToSend) {
        getElement().sendKeys(keysToSend);
        log.info("Sending keys...");
    }

    public void clearInput() {
        getElement().sendKeys(Keys.CONTROL + "a");
        getElement().sendKeys(Keys.DELETE);
    }

    public void enterInput() {
        getElement().sendKeys(Keys.ENTER);
    }

    public void arrowDown() {
        getElement().sendKeys(Keys.ARROW_DOWN);
    }
}

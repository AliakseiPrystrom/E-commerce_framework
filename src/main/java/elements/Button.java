package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.WebDriverManager.getDriver;

public class Button extends BaseElement {

    public Button(By xPath, String nameElement) {
        super(xPath, nameElement);
    }

    public WebElement getElement() {
        return getDriver().findElement(xPath);
    }
}

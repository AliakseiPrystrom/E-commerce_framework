package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.WebDriverManager.getDriver;

public class UniqElement extends BaseElement {

    public UniqElement(By xPath, String nameElement) {
        super(xPath, nameElement);
    }

    public WebElement getElement() {
        return getDriver().findElement(xPath);
    }
}

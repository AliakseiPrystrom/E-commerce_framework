package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static drivers.WebDriverManager.getDriver;

public class Link extends BaseElement {

    public Link(By xPath, String nameElement) {
        super(xPath, nameElement);
    }

    public WebElement getElement() {
        return getDriver().findElement(xPath);
    }

    public List<WebElement> getElements() {
        return getDriver().findElements(xPath);
    }
}

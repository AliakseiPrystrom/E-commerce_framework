package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.WaitUtils;

import static drivers.WebDriverManager.getDriver;

public class BaseElement {
    protected By xPath;
    protected String nameElement;
    static final Logger log = LogManager.getLogger(BaseElement.class.getName());

    public void setXPath(By xPath, String nameElement) {
        this.xPath = xPath;
        this.nameElement = nameElement;
    }

    public By getxPath() {
        return xPath;
    }

    public BaseElement(By xPath, String nameElement) {
        this.xPath = xPath;
        this.nameElement = nameElement;
    }

    public void click() {
        log.info("click on element --> " + nameElement);
        WaitUtils.waitForElementToBePresent(xPath);
        getDriver().findElement(xPath).click();
    }

    public void JSclick() {
        log.info("use JS click on element --> " + nameElement);
        WaitUtils.waitForElementToBePresent(xPath);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", getDriver().findElement(xPath));
    }

    public void JSscroll() {
        log.info("use JS scroll to element --> " + nameElement);
        WaitUtils.waitForElementToBePresent(xPath);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(xPath));
    }

    public String getText() {
        return getDriver().findElement(xPath).getText();
    }

    public String getAttribute(String key) {
        return getDriver().findElement(xPath).getAttribute(key);
    }

    public boolean isVisible() {
        WaitUtils.waitForElementToBePresent(xPath);
        return getDriver().findElement(xPath).isDisplayed();
    }

    @Override
    public String toString() {
        return nameElement + xPath;
    }
}

package tests;

import drivers.BrowserTypes;
import drivers.WebDriverFactory;
import drivers.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static drivers.WebDriverManager.getDriver;

public class BaseTest {

    @BeforeMethod
    public void setUpDriver() {
        WebDriverManager.setDriver(WebDriverFactory.getDriver(BrowserTypes.CHROME));
    }

    @AfterMethod
    public void quitDriver() {
        WebDriverManager.quitDriver(getDriver());
    }
}

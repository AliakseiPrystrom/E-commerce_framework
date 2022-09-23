package drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webdriver.get();
    }

    public static void setDriver(WebDriver driver) {
        webdriver.set(driver);
    }

    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
            webdriver.remove();
        }
    }
}

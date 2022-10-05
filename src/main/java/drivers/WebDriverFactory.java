package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver getDriver(BrowserTypes browserNames) {
        WebDriver driver;
        switch (browserNames) {
            case CHROME:
                driver = getChromeDriver();
                break;
            case FIREFOX:
                driver = getFirefoxDriver();
                break;
            default:
                throw new RuntimeException("Incorrect browser initialization!");
        }
        return driver;
    }

    public static ChromeDriver getChromeDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    public static FirefoxDriver getFirefoxDriver() {
        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("disable-gpu");
        return new FirefoxDriver(firefoxOptions);
    }
}

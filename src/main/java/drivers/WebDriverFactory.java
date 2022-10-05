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

        chromeOptions.addArguments("--disable-gpu");

        chromeOptions.addArguments("--remote-debugging-port=9222");
        chromeOptions.addArguments("--enable-javascript");
        chromeOptions.addArguments("--user-agent='Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:72.0) Gecko/20100101 Firefox/72.0'");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--window-size=1280,800");

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

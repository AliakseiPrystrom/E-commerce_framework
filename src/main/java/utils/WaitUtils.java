package utils;

import drivers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private static final Duration WAIT_TIME = Duration.ofSeconds(5);
    private static WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), WAIT_TIME);
    private static FluentWait<WebDriver> fluentWait = new FluentWait<>(WebDriverManager.getDriver());

    public static void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBePresent(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementToBeInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void createFluentWaitForVisibility(WebElement element, Duration timeout, Duration pollingTime) {
        fluentWait.withTimeout(timeout).pollingEvery(pollingTime).until(ExpectedConditions.visibilityOf(element));
    }

    public static void createFluentWaitForInvisibility(WebElement element, Duration timeout, Duration pollingtime) {
        fluentWait.withTimeout(timeout).pollingEvery(pollingtime).until(ExpectedConditions.invisibilityOf(element));
    }
}

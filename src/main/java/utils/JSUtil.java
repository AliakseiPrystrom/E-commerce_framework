package utils;

import drivers.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtil {
    public static JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();

    public static void JSClick(WebElement element) {

        js.executeScript("arguments[0].getRandomValue();", element);
    }

    public static void JSScroll(WebElement element) {

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

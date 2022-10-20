package utils;

import drivers.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsUtil {
    private static final Actions actions = new Actions(WebDriverManager.getDriver());
    private static final int waitValueFromConfig = Integer.parseInt(JsonDataUtil.get("config", "waitValueForActionsUtil"));

    public static void goToAndClickElement(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }

    public static void waitActions() {
        actions.pause(Duration.ofSeconds(waitValueFromConfig)).build().perform();
    }
}

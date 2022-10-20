package pages;

import drivers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import properties.SetProperty;
import utils.JsonDataUtil;

public abstract class BasePage {
    public final String HOME_URL = JsonDataUtil.get("testurls", "homeUrl");
    public SetProperty property;
    public WebDriver driver;

    public BasePage() {
        property = SetProperty.getInstance();
        driver = WebDriverManager.getDriver();
    }

    public abstract BasePage openPage();

    public abstract boolean isPageOpened();
}

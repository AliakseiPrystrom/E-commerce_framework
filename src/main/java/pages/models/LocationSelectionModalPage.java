package pages.models;

import elements.Button;
import elements.TextField;
import elements.UniqElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HomePage;
import utils.ActionsUtil;
import utils.StringUtil;
import utils.WaitUtils;

import java.util.List;

public class LocationSelectionModalPage extends BasePage {
    private final UniqElement uniqueElement = new UniqElement(By.xpath(StringUtil.correctEncode("//div[text() = 'Где вы находитесь?']")), "uniqueElement");
    private final TextField allLocations = new TextField(By.xpath(StringUtil.correctEncode("//a[@role='button']//span")), "allLocations");
    private final Button goToShopping = new Button(By.xpath(StringUtil.correctEncode("//button[text()='Перейти к покупкам']")), "goToShopping");
    private String pathToCurrentCity = StringUtil.correctEncode("//span[contains(text(),'%s')]");

    @Override
    public LocationSelectionModalPage openPage() {
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqueElement.isVisible();
    }

    private List<WebElement> getAllLocations() {
        return allLocations.getElements();
    }

    public LocationSelectionModalPage chooseLocation(String testLocation) {
        isPageOpened();
        if (testLocation.equals("Brest")) {  //костыль из-за кодировки
            testLocation = "Брест";
        }
        for (WebElement location : getAllLocations()) {
            if (location.getText().contains(testLocation)) {
                location.click();
                break;
            }
        }
        return this;
    }

    public boolean checkSelectedLocation() {
        ActionsUtil.waitActions();
        String location = StringUtil.correctEncode("Брест");
        return new TextField(By.xpath(StringUtil.correctEncode(String.format(pathToCurrentCity, location))), "currentCity").isVisible();
    }

    public HomePage goToShopping() {
        ActionsUtil.waitActions();
        checkSelectedLocation();
        goToShopping.click();
        return new HomePage();
    }
}

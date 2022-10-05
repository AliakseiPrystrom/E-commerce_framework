package pages;

import elements.Button;
import elements.TextField;
import elements.UniqElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.models.LocationSelectionModalPage;
import utils.ActionsUtil;
import utils.StringUtil;

import javax.swing.*;

public class HomePage extends BasePage {
    private final UniqElement uniqueElement = new UniqElement(By.xpath(StringUtil.correctEncode("//h3[text()='Выберите интересующий вас раздел']")), "uniqueHomeMessage");
    private final Button goToSportPage = new Button(By.xpath(StringUtil.correctEncode("//a[text()=' Спорт']")), "goToSportPage");
    private final Button locationSelection = new Button(By.xpath(StringUtil.correctEncode("//div[contains(@class,'go-geo-wrapper')]")), "locationSelectionButton");
    private final Button forMenMenu = new Button(By.xpath(StringUtil.correctEncode("//a[@data-genders='men']")), "forMenMenu");
    private final Button menBackPacks = new Button(By.xpath(StringUtil.correctEncode("//a[contains(@href,'bags-muzhskie-ryukzaki')]//div")), "menBackPacks");
    private final TextField scrollToSlider = new TextField(By.xpath(StringUtil.correctEncode("//div[contains(@class,'icons-banner')]")), "scrollToSlider");
    private final TextField isMenCatalogueOpened = new TextField(By.xpath(StringUtil.correctEncode("//a[@data-genders = 'men' and @data-active = 'true']")), "isMenCatalogueOpened");
    private final TextField currentCitySelected = new TextField(By.xpath(StringUtil.correctEncode("//span/child::span[@class='notranslate']")), "currentCitySelected");

    @Override
    public HomePage openPage() {
        driver.navigate().to(HOME_URL);
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqueElement.isVisible();
    }

    public boolean isMenCatalogueOpenedCheck() {
        return isMenCatalogueOpened.isVisible();
    }

    public boolean checkCurrentLocation() {
        String location = StringUtil.correctEncode("Брест");
        return currentCitySelected.getAttribute("textContent").contains(location);
    }

    public SportCataloguePage goToSportPage() {
        ActionsUtil.waitActions();
        goToSportPage.click();
        return new SportCataloguePage();
    }

    public LocationSelectionModalPage goToLocationSelection() {
        ActionsUtil.waitActions();
        locationSelection.click();
        return new LocationSelectionModalPage();
    }

    public HomePage switchToMenMenu() {
        ActionsUtil.waitActions();
        forMenMenu.click();
        return this;
    }

    public MenBackPacksPage goToMenBackPacksPage() {
        isMenCatalogueOpenedCheck();
        scrollToSlider.JSscroll();
        menBackPacks.click();
        return new MenBackPacksPage();
    }
}

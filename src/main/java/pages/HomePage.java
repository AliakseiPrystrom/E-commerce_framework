package pages;

import elements.Button;
import elements.TextField;
import elements.UniqElement;
import org.openqa.selenium.By;
import pages.models.LocationSelectionModalPage;

public class HomePage extends BasePage {
    private final UniqElement uniqueElement = new UniqElement(By.xpath("//h3[text()='Выберите интересующий вас раздел']"), "uniqueHomeMessage");
    private final Button goToSportPage = new Button(By.xpath("//a[text()=' Спорт']"), "goToSportPage");
    private final Button locationSelection = new Button(By.xpath("//div[contains(@class,'go-geo-wrapper')]"), "locationSelectionButton");
    private final Button forMenMenu = new Button(By.xpath("//a[@data-genders='men']"), "forMenMenu");
    private final Button menBackPacks = new Button(By.xpath("//a[contains(@href,'bags-muzhskie-ryukzaki')]//div"), "menBackPacks");
    private final TextField scrollToSlider = new TextField(By.xpath("//div[contains(@class,'icons-banner')]"), "scrollToSlider");
    private final TextField isMenCatalogueOpened = new TextField(By.xpath("//a[@data-genders = 'men' and @data-active = 'true']"), "isMenCatalogueOpened");
    private final TextField currentCitySelected = new TextField(By.xpath("//span/child::span[@class='notranslate']"), "currentCitySelected");

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
        String location = "Брест";
        return currentCitySelected.getAttribute("textContent").contains(location);
    }

    public SportCataloguePage goToSportPage() {
        goToSportPage.click();
        return new SportCataloguePage();
    }

    public LocationSelectionModalPage goToLocationSelection() {
        locationSelection.click();
        return new LocationSelectionModalPage();
    }

    public HomePage switchToMenMenu() {
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

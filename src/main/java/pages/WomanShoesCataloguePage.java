package pages;

import elements.Link;
import elements.UniqElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.*;

import java.util.List;

public class WomanShoesCataloguePage extends BasePage {
    private final UniqElement uniqElement = new UniqElement(By.xpath(StringUtil.correctEncode("//h1[text()='Женские кроссовки для бега']")), "uniqueElement");
    private final String allShoesPath = StringUtil.correctEncode("//a[@role='link' and text()='%s']");
    private final String SHOES_CATALOGUE_PAGE_ENDPOINT = StringUtil.correctEncode(JsonDataUtil.get("testurls", "womanShoesCataloguePageEndpoint"));

    @Override
    public WomanShoesCataloguePage openPage() {
        driver.navigate().to(HOME_URL + SHOES_CATALOGUE_PAGE_ENDPOINT);
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqElement.isVisible();
    }

    public ShoesPage chooseSelectedShoes(String size) {
        ActionsUtil.waitActions();
        List<WebElement> shoes = new Link(By.xpath(String.format(allShoesPath, size)), "allShoesWithTestSize").getElements();
        int randomValue = GetRandom.getRandomValue(shoes);
        JSUtil.JSScroll(shoes.get(randomValue));
        return new ShoesPage(shoes.get(randomValue).getDomProperty("href")).openPage();
    }
}

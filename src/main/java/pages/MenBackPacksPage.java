package pages;

import elements.TextField;
import elements.UniqElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.StringUtil;
import utils.JsonDataUtil;

import java.util.List;

public class MenBackPacksPage extends BasePage {
    private final UniqElement uniqueElement = new UniqElement(By.xpath("//h1[text()='Мужские рюкзаки и мешки']"), "uniqueElement");
    private final String MEN_BACKPACK_PAGE_ENDPOINT = JsonDataUtil.get("testurls", "menBackpackPageEndpoint");
    private final TextField allBagPacksOnPage = new TextField(By.xpath("//div[@class='x-product-card__card']"), "allBagPacks");

    @Override
    public BasePage openPage() {
        driver.navigate().to(HOME_URL + MEN_BACKPACK_PAGE_ENDPOINT);
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqueElement.isVisible();
    }

    private List<WebElement> getAllBags() {
        return allBagPacksOnPage.getElements();
    }

    public BagPage getTestBag(String testBag) {
        isPageOpened();
        if (testBag.equals("PUMA Bag Phase Backpack")) {
            testBag = "PUMA Рюкзак Phase Backpack";
        }
        for (WebElement bag : getAllBags()) {
            if (StringUtil.compareStrings(testBag, bag.getAttribute("textContent"))) {
                bag.click();
                break;
            }
        }
        return new BagPage();
    }
}

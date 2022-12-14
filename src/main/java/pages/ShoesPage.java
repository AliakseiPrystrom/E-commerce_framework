package pages;

import elements.Label;
import elements.UniqElement;
import org.openqa.selenium.By;
import pages.models.CartModalPage;
import utils.CookieUtil;
import utils.WaitUtils;

public class ShoesPage extends BasePage {
    private final UniqElement uniqueElement = new UniqElement(By.xpath("//span[text()='Добавить в корзину']/parent::button"), "uniqueElement");
    private final Label shoesArticle = new Label(By.xpath("//span[text()='Артикул']/../following-sibling::span"), "shoesArticle");
    private final String shoesLink;

    public ShoesPage(String shoesLink) {
        this.shoesLink = shoesLink;
    }

    @Override
    public ShoesPage openPage() {
        driver.navigate().to(shoesLink);
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqueElement.isVisible();
    }

    public void putArticleInScope() {
        String currentArticle = shoesArticle.getElements().get(0).getText();
        CookieUtil.putInScope("shoesArticle", currentArticle);
    }

    public CartModalPage addShoesToCart() {
        putArticleInScope();
        uniqueElement.JSscroll();
        WaitUtils.waitForElementToBeVisible(uniqueElement.getElement());
        uniqueElement.click();
        return new CartModalPage();
    }
}

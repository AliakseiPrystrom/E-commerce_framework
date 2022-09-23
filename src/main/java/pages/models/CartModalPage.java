package pages.models;

import elements.Button;
import elements.UniqElement;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.CartPage;
import utils.ActionsUtil;

public class CartModalPage extends BasePage {
    private final UniqElement uniqueElement = new UniqElement(By.xpath("//div[@class='d-modal__header']"), "uniqueFitnessMessage");
    private final Button goToCartButton = new Button(By.xpath("//a[@href and text()='Перейти в корзину']"), "goToCartButton");

    @Override
    public CartModalPage openPage() {
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqueElement.isVisible();
    }

    public CartPage goToCart() {
        ActionsUtil.waitActions();
        goToCartButton.JSscroll();
        goToCartButton.click();
        return new CartPage();
    }
}

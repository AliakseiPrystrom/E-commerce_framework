package pages;

import elements.Button;
import elements.Label;
import elements.TextField;
import elements.UniqElement;
import org.openqa.selenium.By;
import pages.models.OrderingFormModel;
import utils.ActionsUtil;
import utils.CookieUtil;
import utils.StringUtil;

public class CartPage extends BasePage {
    private final UniqElement uniqueElement = new UniqElement(By.xpath(StringUtil.correctEncode("//p[text()='Оформление заказа']")), "uniqueElement");
    private final Label checkArticle = new Label(By.xpath("//a[@data-quick]"), "checkArticle");
    private final TextField mainField = new TextField(By.xpath("//main"), "mainField");
    private final String goToOrder = StringUtil.correctEncode("//span[text()='Перейти к оформлению заказа']");

    @Override
    public CartPage openPage() {
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqueElement.isVisible();
    }

    public boolean checkArticle() {
        ActionsUtil.waitActions();
        String articleFromShoesPage = CookieUtil.getFromScope();
        String articleFromCartPage = checkArticle.getAttribute("data-quick");
        return articleFromShoesPage.equals(articleFromCartPage);
    }

    public CartPage validateRequiredCartFields() {
        ActionsUtil.waitActions();
        OrderingFormModel inputPage = new OrderingFormModel();
        if (!mainField.getAttribute("textContent").contains("Оформление заказа")) {
            Button button = new Button(By.xpath(goToOrder), "goToOrder");
            button.click();
            inputPage.showValidationConstraintsSecondWay();
            inputPage.checkValidationValue("hard");

        } else {
            inputPage.showValidationConstraintsFirstWay();
            inputPage.checkValidationValue("easy");
        }
        return this;
    }
}

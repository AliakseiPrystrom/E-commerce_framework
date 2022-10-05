package pages;

import elements.Button;
import elements.Label;
import elements.UniqElement;
import org.openqa.selenium.By;
import pages.models.CartModalPage;
import utils.ActionsUtil;
import utils.JsonDataUtil;
import utils.StringUtil;
import utils.WaitUtils;

import java.util.Locale;

public class BagPage extends BasePage {
    private final UniqElement uniqueElement = new UniqElement(By.xpath("//button[@aria-label='Добавить в корзину']"), "uniqueElement");
    private final Button openDetails = new Button(By.xpath("//span/following-sibling::a"), "openDetails");
    private final Button openColorDropDown = new Button(By.xpath("//div[@tabindex]//a[@role]"), "selectColoDropDown");
    private Label testColorSelect;
    private String currentColorPath = StringUtil.correctEncode("//span[text()='%s']");
    private String testDataColor = JsonDataUtil.get("testdata", "backPackColor");

    @Override
    public BagPage openPage() {
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqueElement.isVisible();
    }

    public BagPage openDetails() {
        WaitUtils.waitForElementToBePresent(openDetails.getxPath());
        openDetails.JSscroll();
        openDetails.click();
        WaitUtils.waitForElementToBeInvisible(openDetails.getxPath());
        return this;
    }

    private void openColorSelect() {
        openColorDropDown.click();
    }

    public BagPage chooseBagColor(String color) {
        openColorSelect();
        color = JsonDataUtil.get("testdata", "backPackColor");
        if (color.equals("Grey")) {
            color = "серый";
        }
        testColorSelect = new Label(By.xpath(String.format(currentColorPath, color)), "selectedBagColor");
        testColorSelect.click();
        return new BagPage();
    }

    public boolean checkChoosedColor() {
        ActionsUtil.waitActions();
        if (testDataColor.equals("Grey")) {
            testDataColor = "серый";
        }
        testColorSelect = new Label(By.xpath(String.format(currentColorPath, testDataColor)), "checkSelectedColor");
        WaitUtils.waitForElementToBeVisible(testColorSelect.getElement());
        String currentBagColor = testColorSelect.getText();
        return currentBagColor.toLowerCase(Locale.ROOT).equals(testDataColor.toLowerCase(Locale.ROOT));
    }

    public CartModalPage addBagToCart() {
        ActionsUtil.waitActions();
        uniqueElement.JSscroll();
        uniqueElement.click();
        return new CartModalPage();
    }
}

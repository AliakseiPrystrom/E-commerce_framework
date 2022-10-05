package pages;

import elements.Button;
import elements.Label;
import elements.UniqElement;
import org.openqa.selenium.By;
import utils.ActionsUtil;
import utils.JsonDataUtil;
import utils.StringUtil;
import utils.WaitUtils;

public class SportCataloguePage extends BasePage {
    private final UniqElement uniqElement = new UniqElement(By.xpath(StringUtil.correctEncode("//div[contains(@class,'js-slick-slide slick-slide slick-current')]/.//p[text()='Кроссовки и кеды']")), "uniqueElement");
    private final Button fitnessPlateButton = new Button(By.xpath(StringUtil.correctEncode("//div[text() = 'Фитнес']/..")), "fitnessPlateButton");
    private final Label fitnessPlates = new Label(By.xpath(StringUtil.correctEncode("//div[@class='sport-types-plates-wrap']")), "fitnessPlates");
    private final String SPORTS_PAGE_ENDPOINT = StringUtil.correctEncode(JsonDataUtil.get("testurls", "womanSportsPageEndpoint"));

    @Override
    public SportCataloguePage openPage() {
        driver.navigate().to(HOME_URL + SPORTS_PAGE_ENDPOINT);
        isPageOpened();
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqElement.isVisible();
    }

    public WomanFitnessPage goFitnessPlate() {
        fitnessPlates.JSscroll();
        WaitUtils.waitForElementToBePresent(fitnessPlateButton.getxPath());
        ActionsUtil.goToAndClickElement(fitnessPlateButton.getElement());
        return new WomanFitnessPage();
    }
}

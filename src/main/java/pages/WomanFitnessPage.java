package pages;

import elements.Button;
import elements.UniqElement;
import org.openqa.selenium.By;
import utils.ActionsUtil;
import utils.JsonDataUtil;
import utils.StringUtil;

public class WomanFitnessPage extends BasePage {
    private final UniqElement uniqElement = new UniqElement(By.xpath(StringUtil.correctEncode("//h1[text() = 'Женские товары для фитнеса']")), "uniqueElement");
    private final Button goToJogButton = new Button(By.xpath("//div[@class='aBcLsXmgsBBuX2JnHhbPt']/following::a[@href='/c/4004/default-sport_women_run/']"), "goToJogButton");
    private final Button shoesButton = new Button(By.xpath("//a[@href='/c/4858/shoes-sport_women_run_krossovki_i_kedy/']"), "shoesButton");
    private final String FITNESS_PAGE_ENDPOINT = JsonDataUtil.get("testurls", "womanFitnessPageEndpoint");

    @Override
    public WomanFitnessPage openPage() {
        driver.navigate().to(HOME_URL + FITNESS_PAGE_ENDPOINT);
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return uniqElement.isVisible();

    }

    public WomanShoesCataloguePage chooseShoes() {
        goToJogButton.JSscroll();
        ActionsUtil.goToAndClickElement(goToJogButton.getElement());
        ActionsUtil.waitActions();
        ActionsUtil.goToAndClickElement(shoesButton.getElement());
        return new WomanShoesCataloguePage();
    }
}

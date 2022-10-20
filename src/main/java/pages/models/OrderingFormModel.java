package pages.models;

import elements.Input;
import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CartPage;
import utils.ActionsUtil;
import utils.ShowValidationUtil;
import utils.WaitUtils;

import java.util.Arrays;
import java.util.List;

public class OrderingFormModel extends CartPage {
    private final Input phoneInput = new Input(By.xpath("//input[@id='phone']"), "phoneInput");
    private final Input cityInput = new Input(By.xpath("//input[@id='city_name']"), "cityInput");
    private final Input fNameInput = new Input(By.xpath("//input[@id='first_name']"), "fNameInput");
    private final Input lNameInput = new Input(By.xpath("//input[@id='last_name']"), "lNameInput");
    private final Input emailInput = new Input(By.xpath("//input[@id='email']"), "emailInput");
    private final Input streetInput = new Input(By.xpath("//input[@id='street']"), "streetInput");
    private final String easyWay = "//div[@class='input__validation-message input__validation-message_default-theme']";
    private final String hardWay = "//div[@class='input-material__validation-message']";

    public void setCityField() {
        cityInput.sendKeys("Минск");
        ActionsUtil.waitActions();
        cityInput.arrowDown();
        cityInput.enterInput();
        cityInput.clearInput();
        ActionsUtil.waitActions();
    }

    public void showValidationConstraintsFirstWay() {
        List<Input> inputs = Arrays.asList(phoneInput, cityInput, fNameInput, lNameInput, emailInput);
        for (Input input : inputs) {
            ShowValidationUtil.sendAndClear(input);
        }
    }

    public void showValidationConstraintsSecondWay() {
        setCityField();
        List<Input> inputs = Arrays.asList(phoneInput, cityInput, fNameInput, lNameInput, emailInput, streetInput);
        for (Input input : inputs) {
            ShowValidationUtil.sendAndClear(input);
        }
    }

    public void checkValidationValue(String type) {
        List<WebElement> validationList;
        switch (type) {
            case ("easy"):
                validationList = new TextField(By.xpath(easyWay), "constraints").getElements();
                for (WebElement element : validationList) {
                    WaitUtils.waitForElementToBeVisible(element);
                }
                break;
            case ("hard"):
                validationList = new TextField(By.xpath(hardWay), "constraints").getElements();
                for (WebElement element : validationList) {
                    WaitUtils.waitForElementToBeVisible(element);
                }
                break;
        }
    }
}

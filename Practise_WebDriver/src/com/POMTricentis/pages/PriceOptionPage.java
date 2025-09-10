package com.POMTricentis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceOptionPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='selectsilver']/..")WebElement silverOption;
    @FindBy(xpath = "//input[@id='selectgold']/..")WebElement goldOption;
    @FindBy(xpath = "//input[@id='selectplatinum']/..")WebElement platinumOption;
    @FindBy(xpath = "//input[@id='selectultimate']/..")WebElement ultimateOption;
    @FindBy(id = "nextsendquote")WebElement nextButton;
    
    public PriceOptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectPriceOption(String option) {
        switch (option.toLowerCase()) {
            case "silver":
                silverOption.click();
                break;
            case "gold":
                goldOption.click();
                break;
            case "platinum":
                platinumOption.click();
                break;
            case "ultimate":
                ultimateOption.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid price option: " + option);
        }
        nextButton.click();
    }
}

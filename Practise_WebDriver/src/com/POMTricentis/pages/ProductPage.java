package com.POMTricentis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;

    @FindBy(id = "startdate") WebElement startDate;
    @FindBy(id = "insurancesum") WebElement insuranceSum;
    @FindBy(id = "meritrating") WebElement meritRating;
    @FindBy(id = "damageinsurance") WebElement damageInsurance;
    @FindBy(xpath = "//*[@id='insurance-form']/div/section[3]/div[5]/p/label[1]/span") WebElement optionalProduct;
    @FindBy(id = "courtesycar") WebElement courtesyCar;
    @FindBy(id = "nextselectpriceoption") WebElement nextButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillProductData(String start, String sum, String merit, String damage,
                                String optional, String courtesy, String vehicleType) {

        startDate.clear();
        startDate.sendKeys(start);
        selectDropdownOption(insuranceSum, sum);
        selectDropdownOption(meritRating, merit);
        selectDropdownOption(damageInsurance, damage);
        selectDropdownOption(courtesyCar, courtesy);

        if (optional.equalsIgnoreCase("yes") && !optionalProduct.isSelected()) {
            optionalProduct.click();
        }

        nextButton.click();
    }

    private void selectDropdownOption(WebElement element, String visibleText) {
        try {
            Select dropdown = new Select(element);
            for (WebElement option : dropdown.getOptions()) {
                if (option.getText().trim().equalsIgnoreCase(visibleText.trim())) {
                    dropdown.selectByVisibleText(option.getText());
                    return;
                }
            }
            System.out.println("Option '" + visibleText + "' not found in dropdown.");
        } catch (Exception e) {
            System.out.println("Dropdown selection failed for value: " + visibleText);
        }
    }
}

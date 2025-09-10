package com.POMTricentis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InsurantPage {
    WebDriver driver;

    @FindBy(id = "firstname")WebElement firstName;
    @FindBy(id = "lastname")WebElement lastName;
    @FindBy(id = "birthdate")WebElement birthDate;
    @FindBy(xpath = "//*[@id='insurance-form']/div/section[2]/div[4]/p/label[1]/span")WebElement genderRadio;
    @FindBy(id = "streetaddress")WebElement address;
    @FindBy(id = "country")WebElement country;
    @FindBy(id = "zipcode")WebElement zipCode;
    @FindBy(id = "city")WebElement city;
    @FindBy(id = "occupation")WebElement occupation;
    @FindBy(xpath = "//*[@id='insurance-form']/div/section[2]/div[10]/p/label[5]/span")WebElement hobbies;
    @FindBy(id = "website")WebElement website;
    @FindBy(id = "picture")WebElement pictureUpload;
    @FindBy(id = "nextenterproductdata")WebElement nextButton;
    
    public InsurantPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }

    public void fillInsurantData(String fname, String lname, String bdate, String gender,
                                 String addr, String countryVal, String zip, String cityVal, String job,
                                 String web, String picturePath) throws InterruptedException {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        birthDate.sendKeys(bdate);
        if (!genderRadio.isSelected()) genderRadio.click();
        address.sendKeys(addr);
        new Select(country).selectByVisibleText(countryVal);
        zipCode.sendKeys(zip);
        city.sendKeys(cityVal);
        new Select(occupation).selectByVisibleText(job);
        if (!hobbies.isSelected()) hobbies.click();
        website.sendKeys(web);
        pictureUpload.sendKeys(picturePath);
        Thread.sleep(3000); // Allow file upload time
        nextButton.click();
    }
}


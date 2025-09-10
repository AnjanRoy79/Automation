package com.POMTricentis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VehiclePage {
    WebDriver driver;

    // Make of the Vehicle
    
    @FindBy(id = "nav_automobile")WebElement automobileLink;
    @FindBy(id = "nav_truck")WebElement truckLink;
    @FindBy(id = "nav_motorcycle")WebElement motorcycleLink;
    @FindBy(id = "nav_camper")WebElement camperLink;
    
    // Filling in the details
    
    @FindBy(id = "make")WebElement make;
    @FindBy(id = "engineperformance")WebElement enginePerformance;
    @FindBy(id = "dateofmanufacture")WebElement dateOfManufacture;
    @FindBy(id = "numberofseats")WebElement numberOfSeats;
    @FindBy(id = "fuel")WebElement fuelType;
    @FindBy(id = "payload")WebElement payload;
    @FindBy(id = "totalweight")WebElement weight;
    @FindBy(id = "cylindercapacity")WebElement ccm;
    @FindBy(id = "righthanddriveyes")WebElement rhd;
    @FindBy(id = "listprice")WebElement listPrice;
    @FindBy(id = "licenseplatenumber")WebElement licensePlate;
    @FindBy(id = "annualmileage")WebElement annualMileage;
    @FindBy(id = "nextenterinsurantdata")WebElement nextButton;
    
    public VehiclePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    // checking for the tabs to be clicked one after another after complete the test
    public void selectVehicleType(String type) {
        if (type.equalsIgnoreCase("automobile")) automobileLink.click();
        if (type.equalsIgnoreCase("truck")) truckLink.click();
        if (type.equalsIgnoreCase("motorcycle")) motorcycleLink.click();
        if (type.equalsIgnoreCase("camper")) camperLink.click();
    }

    public void fillVehicleData(String vehicleType, String makeVal, String enginePerf, String date, String seats,
                                String fuel, String price, String plate, String mileage,
                                String payloadVal, String weightVal, String ccmVal, String rhdFlag) {

        new Select(make).selectByVisibleText(makeVal);
        enginePerformance.sendKeys(enginePerf);
        dateOfManufacture.sendKeys(date);
        new Select(numberOfSeats).selectByVisibleText(seats);
        new Select(fuelType).selectByVisibleText(fuel);
        listPrice.sendKeys(price);
        licensePlate.sendKeys(plate);
        annualMileage.sendKeys(mileage);

        if (vehicleType.equalsIgnoreCase("truck")) {
            payload.sendKeys(payloadVal);
            weight.sendKeys(weightVal);
        } else if (vehicleType.equalsIgnoreCase("motorcycle")) {
            ccm.sendKeys(ccmVal);
            if (rhdFlag.equalsIgnoreCase("yes")) {
                rhd.click();
            }
        }

        nextButton.click();
    }
}

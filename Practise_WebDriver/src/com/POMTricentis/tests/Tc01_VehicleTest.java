package com.POMTricentis.tests;

import com.POMTricentis.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Tc01_VehicleTest {

    WebDriver driver;
    VehiclePage vehiclePage;
    InsurantPage insurantPage;
    ProductPage productPage;
    PriceOptionPage priceOptionPage;
    SendQuotePage sendQuotePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sampleapp.tricentis.com/101/index.php");

        vehiclePage = new VehiclePage(driver);
        insurantPage = new InsurantPage(driver);
        productPage = new ProductPage(driver);
        priceOptionPage = new PriceOptionPage(driver);
        sendQuotePage = new SendQuotePage(driver);
    }

    @Test(dataProvider = "vehicleData")
    public void Vehicle(String vehicleType, String make, String enginePerf, String manDate, String seats,
                        String fuel, String listPrice, String plateNum, String mileage,
                        String payload, String totalWeight, String ccm, String righthanddrive,
                        String fName, String lName, String birthDate, String gender, String address,
                        String country, String zip, String city, String job, String website, String picturePath,
                        String startDate, String insuranceSum, String meritRating, String damageInsurance,
                        String optional, String courtesyCar, String priceOption,
                        String email, String phone, String username, String password, String comment) throws InterruptedException {

        vehiclePage.selectVehicleType(vehicleType);
        vehiclePage.fillVehicleData(vehicleType, make, enginePerf, manDate, seats, fuel, listPrice, plateNum, mileage,
                payload, totalWeight, ccm, righthanddrive);

        insurantPage.fillInsurantData(fName, lName, birthDate, gender, address, country, zip, city, job, website, picturePath);
       // productPage.fillProductData(startDate, insuranceSum, meritRating, damageInsurance, optional, courtesyCar);
        productPage.fillProductData(startDate, insuranceSum, meritRating, damageInsurance, optional, courtesyCar, vehicleType);
        priceOptionPage.selectPriceOption(priceOption);
        sendQuotePage.sendQuote(email, phone, username, password, comment);
    }

    @DataProvider(name = "vehicleData")
    public Object[][] getData() {
        return new Object[][]{
            {
                "automobile", "BMW", "1000", "03/06/2020", "4", "Petrol", "1000", "WB-02-1979", "5000",
                "", "", "", "", // payload, weight, ccm, rhd not required for automobile
                "Anjan", "Roy", "05/16/1979", "Male", "188/ Picnic Garden Road", "India", "700039", "Kolkata", "Employee",
                "https://sampleapp.tricentis.com/101/app.php", "C:\\Users\\anjan.ray\\Desktop\\image.jpg",
                "08/03/2025", "5.000.000,00", "Bonus 5", "Full Coverage", "Yes", "Yes", "Silver",
                "anjanroy@gmail.com", "9830721932", "AnjanR", "Zxcv@786b", "Comment1"
            },
            
            {
                "automobile", "BMW", "1000", "03/06/2020", "4", "Petrol", "1000", "WB-02-1979", "5000",
                "", "", "", "", // payload, weight, ccm, rhd not required for automobile
                "Anjan", "Roy", "05/16/1979", "Male", "188/ Picnic Garden Road", "India", "700039", "Kolkata", "Employee",
                "https://sampleapp.tricentis.com/101/app.php", "C:\\Users\\anjan.ray\\Desktop\\image.jpg",
                "08/03/2025", "5.000.000,00", "Bonus 5", "Full Coverage", "Yes", "Yes", "Gold",
                "anjanroy@gmail.com", "9830721932", "AnjanR", "Zxcv@786b", "Comment2"
            },
            
            {
                "automobile", "BMW", "1000", "03/06/2020", "4", "Petrol", "1000", "WB-02-1979", "5000",
                "", "", "", "", // payload, weight, ccm, rhd not required for automobile
                "Anjan", "Roy", "05/16/1979", "Male", "188/ Picnic Garden Road", "India", "700039", "Kolkata", "Employee",
                "https://sampleapp.tricentis.com/101/app.php", "C:\\Users\\anjan.ray\\Desktop\\image.jpg",
                "08/03/2025", "5.000.000,00", "Bonus 5", "Full Coverage", "Yes", "Yes", "Platinum",
                "anjanroy@gmail.com", "9830721932", "AnjanR", "Zxcv@786b", "Comment3"
            },
            
            {
                "automobile", "BMW", "1000", "03/06/2020", "4", "Petrol", "1000", "WB-02-1979", "5000",
                "", "", "", "", // payload, weight, ccm, rhd not required for automobile
                "Anjan", "Roy", "05/16/1979", "Male", "188/ Picnic Garden Road", "India", "700039", "Kolkata", "Employee",
                "https://sampleapp.tricentis.com/101/app.php", "C:\\Users\\anjan.ray\\Desktop\\image.jpg",
                "08/03/2025", "5.000.000,00", "Bonus 5", "Full Coverage", "Yes", "Yes", "Ultimate",
                "anjanroy@gmail.com", "9830721932", "AnjanR", "Zxcv@786b", "Comment4"
            },

            {
                "truck", "Volvo", "1300", "01/12/2019", "2", "Diesel", "2500", "WB-09-4532", "8000",
                "1000", "3000", "", "", // payload, weight for truck
                "Anjan", "Roy", "06/10/1980", "Male", "188/ Picnic Garden Road", "India", "700020", "Mumbai", "Farmer",
                "https://sampleapp.tricentis.com/101/app.php", "C:\\Users\\anjan.ray\\Desktop\\image.jpg",
                "08/03/2025", "3.000.000,00","No Bonus","Partial Coverage", "Yes", "No", "Gold",
                "anjanroy@gmail.com", "9876543210", "AnjanR", "Pass@123", "Truck test comment"
            },

            {
                "motorcycle", "Honda", "500", "01/01/2021", "2", "Petrol", "800", "MH-01-1111", "2000",
                "", "", "250", "yes", // ccm, rhd for motorcycle
                "Anjan", "Roy", "03/15/1985", "Female", "188/ Picnic Garden Road", "India", "560001", "Bangalore", "Employee",
                "https://sampleapp.tricentis.com/101/app.php", "C:\\Users\\anjan.ray\\Desktop\\image.jpg",
                "06/10/2025", "2.000.000,00", "Bonus 1", "No Coverage", "No", "No", "Platinum",
                "anjanroy@gmail.com", "9876543210", "AnjanR", "Pass@123", "Motorcycle test"
            },

            // Add camper test similarly
        };
    }

    @AfterMethod
    public void close() {
        //driver.quit();
    }
}

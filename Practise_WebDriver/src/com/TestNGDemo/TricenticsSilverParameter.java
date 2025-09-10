package com.TestNGDemo;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class TricenticsSilverParameter {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sampleapp.tricentis.com/101/index.php");
        driver.findElement(By.id("nav_automobile")).click();
    }

    
    @Parameters({
        "make", "enginePerformance", "dateOfManufacture", "numberOfSeats", "fuel",
        "listPrice", "licensePlate", "annualMileage",
        "firstName", "lastName", "birthDate", "gender", "street", "country", "zip", "city", "occupation", "website", "picturePath",
        "startDate", "insuranceSum", "meritRating", "damageInsurance", "optionalProduct", "courtesyCar",
        "expPrice", "expClaim", "expClaimDis", "expCover",
        "email", "phone", "username", "password", "comments"
    })
    @Test
    public void AutomobileInsurance
    (
        String make, String enginePerformance, String dateOfManufacture, String numberOfSeats, String fuel,
        String listPrice, String licensePlate, String annualMileage,
        String firstName, String lastName, String birthDate, String gender, String street, String country, String zip, String city, String occupation, String website, String picturePath,
        String startDate, String insuranceSum, String meritRating, String damageInsurance, String optionalProduct, String courtesyCar,
        String expPrice, String expClaim, String expClaimDis, String expCover,
        String email, String phone, String username, String password, String comments
    ) throws InterruptedException {



        // Vehicle Data
    	
        new Select(driver.findElement(By.id("make"))).selectByVisibleText(make);
        driver.findElement(By.id("engineperformance")).sendKeys(enginePerformance);
        driver.findElement(By.id("dateofmanufacture")).sendKeys(dateOfManufacture);
        new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText(numberOfSeats);
        new Select(driver.findElement(By.id("fuel"))).selectByVisibleText(fuel);
        driver.findElement(By.id("listprice")).sendKeys(listPrice);
        driver.findElement(By.id("licenseplatenumber")).sendKeys(licensePlate);
        driver.findElement(By.id("annualmileage")).sendKeys(annualMileage);
        driver.findElement(By.id("nextenterinsurantdata")).click();

        // Insurant Data
        
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("birthdate")).sendKeys(birthDate);
        WebElement radiob = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]"));
        if(radiob.isSelected()==false)
			radiob.click();
        driver.findElement(By.id("streetaddress")).sendKeys(street);
        new Select(driver.findElement(By.id("country"))).selectByVisibleText(country);
        driver.findElement(By.id("zipcode")).sendKeys(zip);
        driver.findElement(By.id("city")).sendKeys(city);
        new Select(driver.findElement(By.id("occupation"))).selectByVisibleText(occupation);
        WebElement hobbies = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[5]/span"));
        if(hobbies.isSelected()==false)
			hobbies.click();
        driver.findElement(By.id("website")).sendKeys(website);
        driver.findElement(By.id("picture")).sendKeys(picturePath);
        Thread.sleep(2000);
        driver.findElement(By.id("nextenterproductdata")).click();

        // Product Data
        
        driver.findElement(By.id("startdate")).sendKeys(startDate);
        new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText(insuranceSum);
        new Select(driver.findElement(By.id("meritrating"))).selectByVisibleText(meritRating);
        new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText(damageInsurance);
		WebElement opt = driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span"));
		if(opt.isSelected()==false)
			opt.click();
        new Select(driver.findElement(By.id("courtesycar"))).selectByVisibleText(courtesyCar);
        driver.findElement(By.id("nextselectpriceoption")).click();

        // Verification
        
        String actPrice = driver.findElement(By.id("selectsilver_price")).getText();
        String actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[2]")).getText();
        String actClaimDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[2]")).getText();
        String actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[2]")).getText();

        Assert.assertEquals(actPrice, expPrice);
        Assert.assertEquals(actClaim, expClaim);
        Assert.assertEquals(actClaimDis, expClaimDis);
        Assert.assertEquals(actCover, expCover);

        driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[1]/span")).click();
        driver.findElement(By.id("nextsendquote")).click();

        // Send Quote
        
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("phone")).sendKeys(phone);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmpassword")).sendKeys(password);
        driver.findElement(By.id("Comments")).sendKeys(comments);
        driver.findElement(By.id("sendemail")).click();

        String successMessage = driver.findElement(By.xpath("/html/body/div[4]/h2")).getText();
        Assert.assertEquals(successMessage, "Sending e-mail success!");
        driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
        System.out.println(successMessage);
    }

    @AfterClass
    public void close() {
        driver.close();
    }
}

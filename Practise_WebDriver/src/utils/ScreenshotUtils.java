package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);



            //  Add time stamp for uniqueness
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Build file path
            String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots/";
            File folder = new File(screenshotDir);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String finalPath = screenshotDir  + "_" + timestamp + ".png";

            File destFile = new File(finalPath);
            Files.copy(srcFile.toPath(), destFile.toPath());

            return finalPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

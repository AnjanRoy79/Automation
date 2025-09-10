package utils1;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static String rname;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        rname = "SampleTestReport_" + timestamp + ".html";

        String reportPath = System.getProperty("user.dir") + "/TestReport/" + rname;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Orange HRM Test Report");
        sparkReporter.config().setDocumentTitle("Functional Test Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // optional system info
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("Browser", "Chrome");

        return extent;
    }
}

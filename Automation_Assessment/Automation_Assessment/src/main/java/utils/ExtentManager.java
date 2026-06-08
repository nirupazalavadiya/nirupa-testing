package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("reports/extent-report.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String fileName) {
        // Ensure the reports directory exists
        File reportDir = new File("reports");
        if (!reportDir.exists()) {
            reportDir.mkdir();
        }

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Assessment Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("ShopEZ Automation Results");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Student");

        return extent;
    }
}

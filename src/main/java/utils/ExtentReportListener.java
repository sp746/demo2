package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;

public class ExtentReportListener extends TestListenerAdapter implements IReporter {
    private ExtentReports extent;
    private ExtentHtmlReporter htmlReporter;

    @Override
    public void onStart(ITestContext context) {
        htmlReporter = new ExtentHtmlReporter(new File("target/extent-report.html"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
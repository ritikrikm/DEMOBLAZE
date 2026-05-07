package com.carbocalc.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.carbocalc.driver.DriverFactory;
import com.carbocalc.utils.ConfigReader;
import com.carbocalc.utils.ExtentManager;
import com.carbocalc.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);
    private static final ThreadLocal<ExtentTest> TEST_LOG = new ThreadLocal<>();
    private static final ExtentReports EXTENT = ExtentManager.getInstance();

    @Override
    public void onStart(ITestContext context) {
        LOGGER.info("Starting suite: {}", context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = EXTENT.createTest(result.getMethod().getMethodName())
                .assignCategory(result.getTestContext().getName());
        TEST_LOG.set(test);
        LOGGER.info("Started test: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST_LOG.get().log(Status.PASS, "Test passed.");
        if (ConfigReader.getBoolean("screenshot.on.pass")) {
            attachScreenshot(result);
        }
        LOGGER.info("Passed test: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TEST_LOG.get().log(Status.FAIL, result.getThrowable());
        attachScreenshot(result);
        LOGGER.error("Failed test: {}", result.getMethod().getMethodName(), result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TEST_LOG.get().log(Status.SKIP, "Test skipped.");
        LOGGER.warn("Skipped test: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        EXTENT.flush();
        TEST_LOG.remove();
        LOGGER.info("Finished suite: {}", context.getName());
    }

    private void attachScreenshot(ITestResult result) {
        try {
            String screenshotPath = ScreenshotUtils.capture(DriverFactory.getDriver(), result.getMethod().getMethodName());
            if (!screenshotPath.isBlank()) {
                TEST_LOG.get().log(Status.INFO, "Screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (Exception exception) {
            LOGGER.error("Unable to attach screenshot for {}", result.getMethod().getMethodName(), exception);
        }
    }
}

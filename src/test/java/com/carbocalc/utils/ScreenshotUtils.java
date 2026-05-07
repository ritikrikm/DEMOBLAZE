package com.carbocalc.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtils {

    private static final Logger LOGGER = LogManager.getLogger(ScreenshotUtils.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    private ScreenshotUtils() {
    }

    public static String capture(WebDriver driver, String testName) {
        try {
            Path directory = Paths.get("target", "screenshots");
            Files.createDirectories(directory);

            String fileName = testName + "_" + LocalDateTime.now().format(FORMATTER) + ".png";
            Path targetPath = directory.resolve(fileName);

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(source.toPath(), targetPath);

            return targetPath.toString();
        } catch (IOException exception) {
            LOGGER.error("Unable to capture screenshot for test {}", testName, exception);
            return "";
        }
    }
}

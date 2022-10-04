package com.deloitte.hackaton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShooter implements AfterTestExecutionCallback {
    private static final Logger LOG = LogManager.getLogger();
    static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ScreenShooter.driver = driver;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if (context.getExecutionException().isPresent()) {

            String baseFileName = context.getRequiredTestClass().getSimpleName() + "-"
                    + context.getRequiredTestMethod().getName()
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("_dd-MM-uu_HH-mm-ss"));

            File targetFile = new File("errorScreenshots/" + baseFileName + ".png");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(scrFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            targetFile.setReadable(true, false);

            LOG.info("Screenshot saved to " + targetFile.toPath());
        }
    }
}
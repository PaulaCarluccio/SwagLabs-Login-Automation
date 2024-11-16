package steps;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.BasePage;
import utils.DriverFactory;

public class Hooks {

    private WebDriver driver;
    private String resultDirectory;

    @Before
    public void setUp() {
        driver = DriverFactory.initializeDriver();

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        resultDirectory = "results/" + UUID.randomUUID() + "_" + timestamp;
        new File(resultDirectory).mkdirs();

        BasePage.setDriver(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("Scenario failed, capturing screenshot...");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Error Screenshot");

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, new File(resultDirectory + "/error.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}

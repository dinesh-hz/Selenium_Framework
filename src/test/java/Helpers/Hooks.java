package Helpers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Driver_manger;
import utilities.Fileread_Manager;
import utilities.contText;

public class Hooks extends Driver_manger {

    private static final Logger logger = LogManager.getLogger(Hooks.class);


    private static Scenario currentScenario;

    Fileread_Manager file_rad = new Fileread_Manager();

    public static String getScenarioName() {
        return currentScenario != null ? currentScenario.getName() : "UnknownScenario";
    }

    @Before
    public void setup_Browser(Scenario scenario) {


        String filepath ="./download/";

        currentScenario = scenario;


        try {
            file_rad.file_reader();

            if (Driver_manger.getDriver() == null) {

                Driver_manger.launchBrowser(BrowserName.CHROME,filepath);
                Driver_manger.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

            } else {
                System.out.println("already the browser is opened sucessfully");
            }

        } catch (Exception e) {

            System.err.println(e.getMessage()+"hook class error of browser luche");

        }

        logger.info("✅ Browser launched successfully.");
    }

    @After
    public void setup_down_Browser() {
        if (Driver_manger.getDriver() != null) {
            Driver_manger.getDriver().quit(); // Close browser
            Driver_manger.setDriver(null); // Reset for next scenario
        }

        logger.info("✅ Browser closed.");

    }



    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                File srcFile = ((TakesScreenshot) Driver_manger.getDriver()).getScreenshotAs(OutputType.FILE);

                // Create screenshot folder if not exists
                File screenshotFolder = new File("./Screenshots/");
                if (!screenshotFolder.exists()) {
                    screenshotFolder.mkdirs();
                }

                // Clean filename: no space, no colon
                String scenarioName = getScenarioName().replaceAll(" ", "_");
                String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
                String screenshotName = scenarioName + "_" + timestamp + ".png";

                File destFile = new File(screenshotFolder, screenshotName);
                FileUtils.copyFile(srcFile, destFile);

                // Attach to Cucumber Report (optional, if HTML plugin supports it)
                byte[] fileContent = FileUtils.readFileToByteArray(destFile);
                scenario.attach(fileContent, "image/png", screenshotName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

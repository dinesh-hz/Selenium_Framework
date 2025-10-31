package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// this is only run for junit test from junit pakges
//@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/feature_files",

        glue = {"StepDefinition", "Helpers"},

        dryRun = false,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        plugin = {"pretty",

                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/cucumber.json",

                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"}, // just chek failled sceainer faile name save to the text file
        publish = true,
        tags = ("@try")

)
public class TestRunner extends AbstractTestNGCucumberTests {

         /* | Command              | Meaning
            | -------------------- | --------------------------------------------------------------------------------------- |
            | `mvn test`           | Runs test cases only                                                                    |
            | `mvn clean`          | Deletes old reports, target folder                                                      |
            | `mv verify`         | Runs tests **and generates reports** (Cucumber, Extent, etc.)                           |
            | `mvn clean test`     | Cleans old files → Runs tests fresh                                                     |
            | `mvn clean verify` | **Cleans old → Runs all tests → Generates all reports (Cucumber, Extent, Spark, etc.)** |
*/
}

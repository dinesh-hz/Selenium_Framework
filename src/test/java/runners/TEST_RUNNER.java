package runners;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

// this is only run for junit test from junit pakges
//@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/feature_files",


        glue = { "StepDefinition" ,"Helpers"},

        dryRun = false,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        plugin = { "pretty",

                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/cucumber.json",

                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt" }, // just chek failled sceainer faile name save to the text file
        publish = true,
        tags = ("@try")

)
public class TEST_RUNNER extends  AbstractTestNGCucumberTests{



}

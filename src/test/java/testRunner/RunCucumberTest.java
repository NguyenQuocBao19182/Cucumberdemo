package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.testng.annotations.IDataProviderAnnotation;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "C://Users//BaoNQ//IdeaProjects//Cucumberdemo1//Feature//userCreate.feature",
        features = "C://Users//Admin//Cucumberdemo//Feature//Login.feature",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "html:target/cucumber-reports/cucumber.json"}
)
public class RunCucumberTest {

}

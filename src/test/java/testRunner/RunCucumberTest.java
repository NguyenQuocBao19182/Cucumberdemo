package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//Admin//Cucumberdemo//Feature//Login.feature",
        glue="stepDefinitions",
        dryRun=false,
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "html:target/cucumber-reports/cucumber.json"}
)
public class RunCucumberTest {

}

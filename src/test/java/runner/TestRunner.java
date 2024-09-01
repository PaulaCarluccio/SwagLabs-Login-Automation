package runner;

import org.junit.AfterClass;

import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@CucumberOptions(
    features = "src/test/resources",
    glue = "steps", 
    plugin = { "pretty", "html:target/cucumber-reports" }, 
    tags = "@PositiveScenarios or @NegativeScenarios"
)
public class TestRunner {
        @AfterClass
        public static void cleanDriver() {
                BasePage.closeBrowser();
        }

}

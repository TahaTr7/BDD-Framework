package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//DC//IdeaProjects//Assessment//src//test//java//Feature",
        glue = "stepsDefinition",
        plugin = {"json:target/cucumber.json"}
)
public class TestRunner {
}

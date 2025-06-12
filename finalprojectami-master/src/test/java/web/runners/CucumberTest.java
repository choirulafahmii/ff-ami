package web.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "web.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-endtoend-reports.html", "json:target/cucumber-endtoend-reports.json"},
        tags = ""
)
public class CucumberTest {
}


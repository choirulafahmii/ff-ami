package api.tests;

import io.cucumber.junit.platform.engine.Constants;
import io.netty.util.Constant;
import org.junit.platform.suite.api.*;

import java.security.Key;

@Suite
@IncludeEngines("Cucumber")
@SelectClasspathResource("features/api")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@api")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "api.stepdefinitions")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/api/cucumber-reports-api-test.html")

public class ApiTestRunner {
}

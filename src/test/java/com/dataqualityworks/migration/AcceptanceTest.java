package com.dataqualityworks.migration;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/com/dataqualityworks/migration")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/acceptance.html")
@SpringBootTest(classes = {SpringConfiguration.class})
public class AcceptanceTest {
}

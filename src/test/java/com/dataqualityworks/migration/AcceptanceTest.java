package com.dataqualityworks.migration;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.java.BeforeAll;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/com/dataqualityworks/migration")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/acceptance.html")
public class AcceptanceTest {

    @BeforeAll
    public static void before_all() throws Exception {
    }
}

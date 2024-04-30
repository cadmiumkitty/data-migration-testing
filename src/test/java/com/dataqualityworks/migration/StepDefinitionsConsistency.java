package com.dataqualityworks.migration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dataqualityworks.migration.telemetry.TelemetryEvent;
import com.dataqualityworks.migration.telemetry.TelemetryProbe;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsConsistency extends CucumberSpringStepDefinition{

    @Autowired
    private TelemetryProbe probe;

    @Before
    public void beforeAllTests() {
        probe.startSession();
    }

    @After
    public void doSomethingAfter(Scenario scenario) {
        Collection<String> tags = scenario.getSourceTagNames();
        probe.flushSession(tags);
    }

    // ======================================================================
    //
    // Common steps
    //
    //

    @Given("Source is available")
    public void source_is_available() throws Exception {
    }

    @When("Migration is run")
    public void migration_is_run() throws Exception {
    }

    @Then("Target file {string} is available")
    public void target_file_name_is_available(String name) throws Exception {
    }

    // ======================================================================
    //
    // Consistency steps
    //
    //

    @Then("Is consistent with respect to type based on spec {string}")
    public void is_consistent_with_respect_to_type_based_on_spec(String spec) throws Exception {
        probe.recordEvent(TelemetryEvent.builder().commaSeparatedValueColumnContainerName(spec).consistencyDimension("type").build());
    }

    @Then("Is consistent with respect to identity based on spec {string}")
    public void is_consistent_with_respect_to_identity_based_on_spec(String spec) throws Exception {
        probe.recordEvent(TelemetryEvent.builder().commaSeparatedValueColumnContainerName(spec).consistencyDimension("identity").build());
    }

    @Then("Is consistent with respect to nullability based on spec {string}")
    public void is_consistent_with_respect_to_nullability_based_on_spec(String spec) throws Exception {
        probe.recordEvent(TelemetryEvent.builder().commaSeparatedValueColumnContainerName(spec).consistencyDimension("nullability").build());
    }

    @Then("Is consistent with respect to format based on spec {string}")
    public void is_consistent_with_respect_to_format_based_on_spec(String spec) throws Exception {
        probe.recordEvent(TelemetryEvent.builder().commaSeparatedValueColumnContainerName(spec).consistencyDimension("format").build());
    }

    // ======================================================================
    //
    // Accuracy steps
    //
    //

    @Then("Record where {string} is {string} has {string} as {string}")
    public void record_where_lookup_column_is_value_has_check_column_expected_value(
            String lookupColumn, String lookupValue, String expectedColumn, String expectedValue) throws Exception {
    }

    // ======================================================================
    //
    // Completeness steps
    //
    //

    @Then("Count for {string} with {string} is {int}")
    public void record_where_dimension_with_value_is_expected_count(
            String dimension, String value, Integer count) throws Exception {
    }
}

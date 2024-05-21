package com.dataqualityworks.migration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataqualityworks.migration.graph.Graph;
import com.dataqualityworks.migration.telemetry.TelemetryProbe;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends CucumberSpringStepDefinition {

    @Autowired
    private Graph graph;

    @Autowired
    private TelemetryProbe probe;

    // ======================================================================
    //
    // Hooks to deal with basic telemetry
    //
    //

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

    @Given("Source is accessible")
    public void source_is_accessible() throws Exception {
    }

    @When("Migration is run")
    public void migration_is_run() throws Exception {
    }

    @Then("Target file {string} is accessible")
    public void target_file_string_is_accessible(String name) throws Exception {
    }

    @Then("Other file {string} is accessible")
    public void other_file_string_is_accessible(String name) throws Exception {
    }

    @Then("Master file {string} is accessible")
    public void master_file_string_is_accessible(String name) throws Exception {
    }

    @When("Specification for {string} is loaded")
    public void specification_for_string_is_loaded(String s) {
    }

    @Given("Specification for {string} is accessible")
    public void specification_for_string_is_accessible(String s) {
    }

    @Then("Manifest file {string} is accessible")
    public void manifest_file_is_accessible(String s) {
    }

    @And("Referenced file {string} is accessible")
    public void referenced_file_string_is_accessible(String name) throws Exception {
    }

    // ======================================================================
    //
    // Accuracy steps
    //
    //

    @Then("Record where {string} is {string} has {string} as {string}")
    public void record_where_string_is_string_has_string_as_string(
            String lookupColumn, String lookupValue, String expectedColumn, String expectedValue) throws Exception {
    }

    // ======================================================================
    //
    // Availability steps
    //
    //

    @Then("Record count is more than {int}")
    public void record_count_is_more_than_int(int i1) {
    }

    // ======================================================================
    //
    // Completeness steps
    //
    //

    @Then("All attributes are present based on {string} specification")
    public void all_attributes_are_present_based_on_string_spec(String s1) {
    }

    @And("Record count for {string} of {string} is {int}")
    public void record_count_for_string_of_string_is_int(String s1, String s2, int i1) {
    }

    @Then("Contains all attributes defined in {string} specification")
    public void contains_all_attributes_defined_in_string_specification(String s1) {
    }

    @Then("Attribute {string} has all numeric values between {int} and {int}")
    public void Attribute_has_all_numeric_values_between_int_and_int(String s, int i1, int i2) {
    }

    @Then("Attribute {string} has all values in set {string}")
    public void Attribute_has_all_values_in_set_string(String s1, String s2) {
    }

    @Then("Specification for {string} is complete with respect to label")
    public void specification_for_string_is_complete_with_respect_to_label(String s1) {
    }

    @Then("Specification for {string} is complete with respect to comment")
    public void specification_for_string_is_complete_with_respect_to_comment(String s1) {
    }

    @Then("Specification for {string} is complete with respect to type")
    public void specification_for_string_is_complete_with_respect_to_type(String s1) {
    }

    @Then("Specification for {string} is complete with respect to identity")
    public void specification_for_string_is_complete_with_respect_to_identity(String s1) {
    }

    @Then("Specification for {string} is complete with respect to nullability")
    public void specification_for_string_is_complete_with_respect_to_nullability(String s1) {
    }

    // ======================================================================
    //
    // Consistency steps
    //
    //

    @And("All categories have a parent category")
    public void all_categories_have_a_parent_category() {
    }

    @And("Distribution of values in {string} is matching the distribution from previous run in {string} with respect to {string} with {int}")
    public void distribution_of_values_in_string_is_matching_the_distribution_from_previous_run_in_string_with_respect_to_string_with_int(String s1, String s2, String s3, int i1) {
    }

    @And("Distribution of values in {string} is matching the distribution of values in {string} with respect to {string}")
    public void distribution_of_values_in_string_is_matching_the_distribution_of_values_in_string_with_respect_to_string(String s1, String s2, String s3) {
    }

    @And("Distribution of values for {string} where {string} is {string} and {string} and with respect to {string} is within {int}")
    public void distribution_of_values_for_string_where_string_is_string_and_string_and_with_respect_to_string_is_within_int(String s1, String s2, String s3, String s4, String s5, int i1) {
    }

    @And("Where country is {string} state is in {string}")
    public void where_country_is_string_state_is_in_string(String s1, String s2) {
    }

    // ======================================================================
    //
    // Currency steps
    //
    //

    @And("Difference between timestamp in {string} and {string} is below {int}")
    public void difference_between_timestamp_in_string_and_string_is_below_int(String s1, String s2, int i1) {
    }

    // ======================================================================
    //
    // Integrity steps
    //
    //

    @Then("Simple checksum is matching manifest checksum")
    public void simple_checksum_is_matching_manifest_checksum() {
    }

    // ======================================================================
    //
    // Latency
    //
    //

    @And("Difference between timestamp in {string} and target timestamp is below {int} seconds")
    public void difference_between_timestamp_in_string_and_target_timestamp_is_below_int(String s1, int i1) {
    }

    // ======================================================================
    //
    // Metadata Compliance steps
    //
    //

    @Then("Specification for {string} is compliant with respect to type")
    public void specification_for_string_is_compliant_with_respect_to_type(String s1) {
    }

    @Then("Specification for {string} is compliant with respect to identity")
    public void specification_for_string_is_compliant_with_respect_to_identity(String s1) {
    }

    @Then("Specification for {string} is compliant with respect to nullability")
    public void specification_for_string_is_compliant_with_respect_to_nullability(String s1) {
    }

    // ======================================================================
    //
    // Plausibility steps
    //
    //

    @And("Values in {string} have {string} with {int}")
    public void values_in_string_have_string_with_int(String s1, String s2, int i1) {
    }

    // ======================================================================
    //
    // Precision steps
    //
    //

    @And("Values in {string} have precision matching the {string} and precision is used in at least {double} records")
    public void values_in_string_have_precision_matching_the_string_and_precision_is_used_in_at_least_int_records(String s1, String s2, double d1) {
    }

    // ======================================================================
    //
    // Reasonability steps
    //
    //

    @And("Values in {string} have {string} of {double} with {double}")
    public void values_in_string_have_string_of_float_with_int(String s1, String s2, double d1, double d2) {
    }

    // ======================================================================
    //
    // Referential integrity steps
    //
    //

    @And("Values referenced from {string} exist in the {string}")
    public void values_referenced_from_string_exist_in_the_string(String s1, String s2) {
    }

    // ======================================================================
    //
    // Retention period steps
    //
    //

    @And("Difference between timestamp in {string} and target timestamp is below {int} years")
    public void difference_between_timestamp_in_string_and_target_timestamp_is_below_int_years(String s1, int i1) {
    }

    // ======================================================================
    //
    // Timeliness steps
    //
    //

    @And("Difference between timestamp in {string} and target timestamp is below {int} days")
    public void difference_between_timestamp_in_string_and_target_timestamp_is_below_int_days(String s1, int i1) {
    }

    // ======================================================================
    //
    // Uniquness steps
    //
    //

    @And("There are no duplicate values in {string}")
    public void there_are_no_duplicate_values_in_string(String s1) {
    }

    @And("Based on {string} probability of representing the same entity in the real world is no more than {float}")
    public void based_on_string_probability_of_representing_the_same_entity_in_the_real_world_is_no_more_than_float(String s1, float f1) {
    }

    // ======================================================================
    //
    // Validaty steps
    //
    //

    @And("Type is valid based on {string} specification")
    public void type_is_valid_based_on_string_specification(String s1) {
    }

    @And("Identity is valid based on {string} specification")
    public void identity_is_valid_based_on_string_specification(String s1) {
    }

    @And("Nullability is valid based on {string} specification")
    public void nullability_is_valid_based_on_string_specification(String s1) {
    }

    @And("Format is valid based on {string} specification")
    public void format_is_valid_based_on_string_specification(String s1) {
    }
}

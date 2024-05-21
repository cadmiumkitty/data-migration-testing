@categories @dim-consistency
Feature: categories.csv extract values are valid with the respect to specification

  Scenario: Extract values are valid with respect to specification with respect to type
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Type is valid based on "categories.csv" specification

  Scenario: Extract values are valid with respect to specification with respect to identity
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Identity is valid based on "categories.csv" specification

  Scenario: Extract values are valid with respect to specification with respect to nullability
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Nullability is valid based on "categories.csv" specification

  Scenario: Extract values are valid with respect to specification with respect to format
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Format is valid based on "categories.csv" specification

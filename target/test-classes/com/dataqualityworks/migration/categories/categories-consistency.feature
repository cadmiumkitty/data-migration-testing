@categories @dim-consistency
Feature: categories.csv extract is consistent with the respect to specification

  Scenario: Extract is consistent with the specification with respect to type
    Given Source is available
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is available
    And Is consistent with respect to type based on spec "categories.csv"

  Scenario: Extract is consistent with the specification with respect to identity
    Given Source is available
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is available
    And Is consistent with respect to identity based on spec "categories.csv"

  Scenario: Extract is consistent with the specification with respect to nullability
    Given Source is available
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is available
    And Is consistent with respect to nullability based on spec "categories.csv"

  Scenario: Extract is consistent with the specification with respect to format
    Given Source is available
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is available
    And Is consistent with respect to format based on spec "categories.csv"

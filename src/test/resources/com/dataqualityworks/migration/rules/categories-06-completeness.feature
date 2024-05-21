@categories @dim-completeness
Feature: categories.csv extract is complete with respect to all values present against expectations
  # Generally, this is a check that all mandatory values are present in the dataset.

  Scenario: Extract is complete with respect to all values present
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Contains all attributes defined in "categories.csv" specification

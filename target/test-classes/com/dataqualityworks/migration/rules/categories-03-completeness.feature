@categories @dim-completeness
Feature: categories.csv extract is complete with respect to all attributes present
  # Generally, is composition of the data container correct with respect to some expectation.

  Scenario: Extract is complete with respect to attributes
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And All attributes are present based on "categories.csv" specification

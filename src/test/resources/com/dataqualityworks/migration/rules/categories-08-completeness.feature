@categories @dim-completeness
Feature: Specification for categories.csv is complete with respect to specification format
  # This is a metadata check, in this case it is possible because specification 
  # is supplied as part of the data migration framework.

  Scenario: Specification for categories.csv is complete with respect to label
    Given Specification for "categories.csv" is accessible
    When Specification for "categories.csv" is loaded
    Then Specification for "categories.csv" is complete with respect to label

  Scenario: Specification for categories.csv is complete with respect to comment
    Given Specification for "categories.csv" is accessible
    When Specification for "categories.csv" is loaded
    Then Specification for "categories.csv" is complete with respect to comment

  Scenario: Specification for categories.csv is complete with respect to type
    Given Specification for "categories.csv" is accessible
    When Specification for "categories.csv" is loaded
    Then Specification for "categories.csv" is complete with respect to type

  Scenario: Specification for categories.csv is complete with respect to identity
    Given Specification for "categories.csv" is accessible
    When Specification for "categories.csv" is loaded
    Then Specification for "categories.csv" is complete with respect to identity

  Scenario: Specification for categories.csv is complete with respect to nullability
    Given Specification for "categories.csv" is accessible
    When Specification for "categories.csv" is loaded
    Then Specification for "categories.csv" is complete with respect to nullability

@categories @dim-currency
Feature: Values in categories.csv extract are current
  # Check of currency against the master source, e.g. against a classification scheme published by authority.

  Scenario Outline: Extract is consistent with respect to values of attributes within records
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Master file "data/categories-master.csv" is accessible
    And Difference between timestamp in "<column>" and "<master column>" is below <tolerance in seconds>

    Examples:
      | column      | master column | tolerance in seconds |
      | LastUpdated | LastUpdated   |                   60 |

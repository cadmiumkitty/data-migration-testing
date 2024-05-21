@categories @dim-consistency
Feature: categories.csv extract is consistent with respect to business rules
  # Generally, consistency with an arbitrary business rule at any level of granularity.

  Scenario: Extract is consistent with respect to hierarchy business rule for parent categories
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And All categories have a parent category

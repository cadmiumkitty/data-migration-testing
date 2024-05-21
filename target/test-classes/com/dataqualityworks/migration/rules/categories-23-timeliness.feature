@categories @dim-timeliness
Feature: Time between record creation and availability for categories.csv is within tolerance
  # Different from latency, but is in effect the same test of whether record is fresh enough.

  Scenario Outline: Timeliness is within tolerance
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Difference between timestamp in "<column>" and target timestamp is below <threshold> days

    Examples:
      | column      | threshold |
      | LastUpdated |       360 |

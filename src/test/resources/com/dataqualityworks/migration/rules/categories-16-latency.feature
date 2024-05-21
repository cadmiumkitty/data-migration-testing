@categories @dim-latency
Feature: categories.csv processing time is within tolerance
  # Check for latency, i.e. time of the record versus time when data is available.
  # In case of a file extract we can check record versus file timestamp.

  Scenario Outline: Extract processing time is within tolerance
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Difference between timestamp in "<column>" and target timestamp is below <threshold> seconds

    Examples:
      | column      | threshold |
      | LastUpdated |        60 |

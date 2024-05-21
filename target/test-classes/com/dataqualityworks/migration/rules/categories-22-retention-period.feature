@categories @dim-retention-period
Feature: Records in categories.csv are not retained beyond the retention period
  # Check needs to be done from the time of removal or a proxy (e.g. account closure).

  Scenario Outline: Retention criateria are met
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Difference between timestamp in "<column>" and target timestamp is below <threshold> years

    Examples:
      | column           | threshold |
      | RemovalTimestamp |         7 |

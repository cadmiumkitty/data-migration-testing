@categories @dim-consistency
Feature: categories.csv extract is consistent with respect to values of attributes within records
  # Generally, this is similar to consistency with an arbitrary business rule.

  Scenario Outline: Extract is consistent with respect to values of attributes within records
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Where country is "<country>" state is in "<state>"

    Examples:
      | country   | state                    |
      | Australia | NSW,VIC,TAS,NT,WA,SA,QLD |

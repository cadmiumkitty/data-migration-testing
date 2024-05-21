@categories @dim-consistency
Feature: categories.csv extract is consistent with respect to values of attributes over time
  # Consistency of the values over time, e.g. is the count, mean, min, max are changing significantly
  # from one run to the next.

  Scenario Outline: Extract is consistent with respect to values of attributes from previous run
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Distribution of values in "<column>" is matching the distribution from previous run in "<time>" with respect to "<statistic>" with <tolerance>

    Examples:
      | column            | time | statistic | tolerance |
      | ProductCategoryID | T-1D | count     |         0 |
      | ProductCategoryID | T-1W | count     |         0 |
      | ProductCategoryID | T-1M | count     |         0 |

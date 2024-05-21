@categories @dim-consistency
Feature: categories.csv extract is consistent with respect to values of attributes across data sets
  # Generally, are we using the same signs to represent the same thing across the datasets.

  Scenario Outline: Extract is consistent with respect to values of attributes across data sets
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Other file "data/product-models-{timestamp}.csv" is accessible
    And Distribution of values in "<column>" is matching the distribution of values in "<other column>" with respect to "<statistic>"

    Examples:
      | column              | other column        | statistic |
      | ProductCategoryName | ProductCategoryName | set       |

@categories @dim-reasonability
Feature: Values in categories.csv extract are reasonable with respect to expected values
  # Check against something we know about the distrobution of the values, e.g. transaction amounts.

  Scenario Outline: Values in extract are reasonable with respect to expected values
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Values in "<column>" have "<statistics>" of <value> with <tolerance>

    Examples:
      | column            | statistics | value | tolerance |
      | ProductCategoryID | min        |     5 |         0 |
      | ProductCategoryID | max        |    20 |       0.5 |
      | ProductCategoryID | mean       |    20 |       0.5 |

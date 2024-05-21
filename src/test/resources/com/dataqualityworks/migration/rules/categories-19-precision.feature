@categories @dim-precision
Feature: Values in categories.csv extract are precise with respect to specification
  # Although generally precision is with respect to measurement and thus true value, we are interpreting it narrowly
  # as ability to store numerical values with certain precision and whether that ability is actually used
  # (e.g. ability to store 0.123456789 may in reality be used as 1.000000000).

  Scenario Outline: Values in the extract are precise with respect to specification
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Values in "<column>" have precision matching the "<specification>" and precision is used in at least <threshold> records

    Examples:
      | column            | specification  | threshold |
      | ProductCategoryID | categories.csv |       0.9 |

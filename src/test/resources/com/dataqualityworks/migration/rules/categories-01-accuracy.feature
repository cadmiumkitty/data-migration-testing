@categories @dim-accuracy
Feature: categories.csv extract is accurate with respect to source
  # Generally, it is a comparison to true value, whatever definition of true value we adopt
  # (e.g. versus authoritative source, expectation of a test).

  Scenario Outline: Extract is accurate with respect to source and expected transformations
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Record where "<lookup column>" is "<lookup value>" has "<expected column>" as "<expected value>"

    Examples:
      | lookup column     | lookup value | expected column           | expected value |
      | ProductCategoryID |           30 | ProductCategoryName       | Bike Racks     |
      | ProductCategoryID |           30 | ParentProductCategoryName | Accessories    |

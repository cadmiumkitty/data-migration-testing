@categories @dim-accuracy
Feature: categories.csv extract is accurate with respect to source and rules

  Scenario Outline: Extract is complete with respect to source along the dimension
    Given Source is available
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is available
    And Record where "<lookup column>" is "<lookup_value>" has "<expected column>" as "<expected value>"

    Examples:
      | lookup column     | lookup value | expected column           | expected value |
      | ProductCategoryID |           30 | ProductCategoryName       | Bike Racks     |
      | ProductCategoryID |           30 | ParentProductCategoryName | Accessories    |

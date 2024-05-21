@categories @dim-consistency
Feature: categories.csv extract is consistent with respect to values of attributes across records
  # Generally, are we using the same signs to represent the same thing across some dimensions
  # within a dataset, e.g. time, type.

  Scenario Outline: Extract is consistent with respect to values of attributes across records
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Distribution of values for "<column>" where "<lookup column>" is "<lookup column value one>" and "<lookup column value two>" and with respect to "<statistic>" is within <tolerance>

    Examples:
      | column              | lookoup column            | lookoup column value one | lookoup column value two | statistic | tolerance |
      | ProductCategoryName | ParentProductCategoryName | Clothing                 | Components               | min       |         0 |
      | ProductCategoryName | ParentProductCategoryName | Clothing                 | Components               | max       |         0 |
      | ProductCategoryName | ParentProductCategoryName | Clothing                 | Components               | mean      |         0 |
      | ProductCategoryName | ParentProductCategoryName | Clothing                 | Components               | var       |         0 |
      | ProductCategoryName | ParentProductCategoryName | Clothing                 | Components               | std       |         0 |

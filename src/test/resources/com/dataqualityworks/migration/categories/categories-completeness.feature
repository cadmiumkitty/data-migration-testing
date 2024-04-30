@categories @dim-consistency
Feature: categories.csv extract is complete with respect to source

  Scenario Outline: Extract is complete with respect to source along the dimension
    Given Source is available
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is available
    And Count for "<dimension>" with "<value>" is <expected count>

    Examples:
      | dimension                 | value       | expected count |
      | ParentProductCategoryName | Accessories |             12 |
      | ParentProductCategoryName | Bikes       |              3 |
      | ParentProductCategoryName | Clothing    |              8 |
      | ParentProductCategoryName | Components  |             14 |

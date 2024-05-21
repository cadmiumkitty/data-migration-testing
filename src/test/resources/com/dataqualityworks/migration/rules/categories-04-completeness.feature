@categories @dim-completeness
Feature: categories.csv extract is complete with respect to source
  # Generally, this is similar to profiling results, but really just a way to compare populations.

  Scenario Outline: Extract is complete with respect to source along all dimensions
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Record count for "<dimension>" of "<value>" is <expected>

    Examples:
      | dimension                 | value       | expected |
      | ParentProductCategoryName | Accessories |       12 |
      | ParentProductCategoryName | Bikes       |        3 |
      | ParentProductCategoryName | Clothing    |        8 |
      | ParentProductCategoryName | Components  |       14 |

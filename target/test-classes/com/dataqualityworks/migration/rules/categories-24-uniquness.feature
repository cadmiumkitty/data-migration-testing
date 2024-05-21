@categories @dim-uniquness
Feature: Records in the categories.csv extract are unique
  # Although there are two different ways to define uniqueness (whether values in a given column are unique
  # versus whether each record represents a unique entities in the real world)
  # both can be covered by the same rule.

  Scenario Outline: Values in specific columns of the extract are unique
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And There are no duplicate values in "<column>"

    Examples:
      | column            |
      | ProductCategoryID |

  Scenario Outline: Records in the extract represent unique entities in the real world
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Based on "<columns>" probability of representing the same entity in the real world is no more than <threshold>

    Examples:
      | column                                         | threshold |
      | ProductCategoryName, ParentProductCategoryName |      0.05 |

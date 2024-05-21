@categories @dim-referential-integrity
Feature: categories.csv extract has referential integrity with people.csv
  # Generally, making sure that relationships between datasets are valid, i.e. records referenced
  # from one dataset exist in another.

  Scenario Outline: Extract has referential integrity
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Referenced file "data/people-{timestamp}.csv" is accessible
    And Values referenced from "<source column>" exist in the "<target column>"

    Examples:
      | source column | target column |
      | Editor        | Email         |

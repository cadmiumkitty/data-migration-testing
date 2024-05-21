@categories @dim-availability
Feature: categories.csv extract has data available
  # Generally, it needs to be interpreted in a way similar to availability of a system, 
  # so needs to be measured over time. In simplest case we can check the count of records in a dataset.

  Scenario Outline: Data in the extract is available
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Record count is more than 0

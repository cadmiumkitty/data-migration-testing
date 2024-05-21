@categories @dim-completeness
Feature: categories.csv extract is present
  # Generally, this is applicable when multimple extracts have to be present at the same time, 
  # e.g. in a migration scenario.

  Scenario: Extract is present
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible

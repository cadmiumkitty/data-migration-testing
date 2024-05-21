@categories @dim-completeness
Feature: categories.csv extract is complete with respect to all possible values of an attribute being present against expectations
  # Generally, this is a check against the expectation that we have, e.g. customers from all Australian states
  # and expect to use all of these values in a given column/

  Scenario: Extract is complete with respect to all numerical values of an attribute being present
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Attribute "ProductCategoryID" has all numeric values between 5 and 41

  Scenario: Extract is complete with respect to all string values of an attribute being present
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Attribute "ParentProductCategoryName" has all values in set "('Accessories', 'Clothing', 'Components', 'Bikes')"

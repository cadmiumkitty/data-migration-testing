@categories @dim-plausibility
Feature: Values in categories.csv extract are plausible with respect to natual distribution
  # Check against something we know about natural world, e.g. a well-known distribution like Benford's Law.
  # Note that some values, like sequentially assigned identifiers, are not expected to follow Benford's Law.

  Scenario Outline: Values in extract are plausible with respect to expected natual distribution
    Given Source is accessible
    When Migration is run
    Then Target file "data/product-models-{timestamp}.csv" is accessible
    And Values in "<column>" have "<distribution>" with <tolerance>

    Examples:
      | column            | distribution | tolerance |
      | ProductCategoryID | bedford law  |         0 |

@categories @dim-metadata-compliance
Feature: Specification for categories.csv is compliant with respect to specification format
  # This is a metadata check, in this case it is possible because specification 
  # is supplied as part of the data migration framework.
  # Different from metadata completeness check as we are checking not the completeness (present of not)
  # but whether format of the specification is correct (are we specifying type or identity correctly)

  Scenario: Specification for categories.csv is compliant with respect to type
    Given Specification for "categories.csv" is accessible
    When Specification for "categories.csv" is loaded
    Then Specification for "categories.csv" is compliant with respect to type

  Scenario: Specification for categories.csv is compliant with respect to identity
    Given Specification for "categories.csv" is accessible
    When Specification for "categories.csv" is loaded
    Then Specification for "categories.csv" is compliant with respect to identity

  Scenario: Specification for categories.csv is compliant with respect to nullability
    Given Specification for "categories.csv" is accessible
    When Specification for "categories.csv" is loaded
    Then Specification for "categories.csv" is compliant with respect to nullability

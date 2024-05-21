@categories @dim-integrity
Feature: Records in categories.csv has integrity
  # Integrity of data as opposed to referential integrity, i.e. was data corrupted in any way.

  Scenario: Data in categories.csv has integrity with respect to supplied manifest file
    Given Source is accessible
    When Migration is run
    Then Target file "data/categories-{timestamp}.csv" is accessible
    And Manifest file "data/categories-manifest-{timestamp}.csv" is accessible
    And Simple checksum is matching manifest checksum

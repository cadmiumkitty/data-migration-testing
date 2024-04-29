# Demo of the data migration testing

## Specifications

Simple set of data specifications is created based on Azure SQL `SalesLT` database to show some key principles behind data migration testing framework.

| File                   | What's inside                            |
| ---------------------- | ---------------------------------------- |
| business-units.csv     | Business Units definitions               |
| containers-targets.csv | Target data containers                   |
| containers-sources.csv | Source data containers                   |
| mappings.csv           | Source to target mappings                |
| people.csv             | People at the org                        |
| business-units.csv     | Business Units definitions               |
| terms.csv              | Definitions of all the terms used        |
| actions.csv            | Definition of the transformation actions |

## Design decisions

1. Simple naming for the terms with one exception for personInRole naming for Owner, Steward and Expert to keep compatibility with other work.

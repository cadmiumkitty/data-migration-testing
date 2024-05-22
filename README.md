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

## Dimensions and Rules

Out of 60 dimensions listed the Dimensions of Data Quality (DDQ) Research Paper only 25 can realistically be 
tested in an automated manner with a rule-based tool.

| DAMA Dimension        | How to measure                                                                                                                    |
| --------------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| Accuracy              | Check difference against the true value.                                                                                          |
| Availability          | Check if data is present.                                                                                                         |
| Completeness          | Check if all attributes in the dataset are present against specification or expectation.                                          |
| Completeness          | Check that all records are present versus expectation (another source) across a series of dimensions.                             |
| Completeness          | All data files are present against expectation.                                                                                   |
| Completeness          | All values are present against expectation.                                                                                       |
| Completeness          | Check that full range of values are present.                                                                                      |
| Completeness          | Check that all mandatory spec attributes are present.                                                                             |
| Consistency           | Values are consistent with some validation rules across the entire dataset.                                                       |
| Consistency           | Distribution check for values against the same dataset.                                                                           |
| Consistency           | Distribution check for values against another dataset.                                                                            |
| Consistency           | Distribution check for values against another record.                                                                             |
| Consistency           | Distribution check for values against same record.                                                                                |
| Currency              | Measure difference between record creation or update time versus an alternative source.                                           |
| Integrity             | Compute checksum and check whether matches expectation.                                                                           |
| Latency               | Measure difference between record creation time and availability for consumption time.                                            |
| Metadata compliance   | Check that all present spec attributes are matching the spec.                                                                     |
| Plausibility          | Check that distribution of values is following some natural law, like Benford's law.                                              |
| Precision (1)         | Check that format is correct against expectation for a given type of data.                                                        |
| Reasonability         | Check that distribution characteristics such as mean, variance, standard deviation are within expectation.                        |
| Referential integrity | Record referenced by a key in one dataset are present in another dataset.                                                         |
| Retention period      | Measure difference between record creation or update time and measurement time.                                                   |
| Timeliness            | Measure difference between record creation or update time and measurement time.                                                   |
| Uniqueness            | Estimate probability that record is a duplicate (represents same thing) within a dataset based on some combination of attributes. |
| Validity              | Check that format is correct against expectation for a given type of data.                                                        |

## Design decisions

1. Simple naming for the terms with one exception for personInRole naming for Owner, Steward and Expert to keep compatibility with other work.
2. Simple probe at this point to record testing events, we can probably implement it as annotations over time.
3. Keep per-dataset per-dimension features to simplify tagging.

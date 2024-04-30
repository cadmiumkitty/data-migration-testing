package com.dataqualityworks.migration.configuration;

import java.util.List;

import lombok.Data;

@Data
public class ReaderConfiguration {
    private List<CsvFileConfiguration> csv;
}

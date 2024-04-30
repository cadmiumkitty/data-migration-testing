package com.dataqualityworks.migration.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "com.dataqualityworks.rdfbuilder")
@Data
public class RdfBuilderConfigurationProperties {
    private ReaderConfiguration reader;
    private WriterConfiguration writer;
    private List<NamespaceConfiguration> namespaces;
}

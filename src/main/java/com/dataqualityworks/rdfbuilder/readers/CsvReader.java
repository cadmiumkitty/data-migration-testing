package com.dataqualityworks.rdfbuilder.readers;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.DCTERMS;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.SKOS;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dataqualityworks.rdfbuilder.configuration.CsvFileConfiguration;
import com.dataqualityworks.rdfbuilder.configuration.NamespaceConfiguration;
import com.dataqualityworks.rdfbuilder.configuration.RdfBuilderConfigurationProperties;
import com.dataqualityworks.rdfbuilder.graph.Graph;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CsvReader {

    @Autowired
    private RdfBuilderConfigurationProperties properties;

    @Autowired
    private Graph graph;

    public void readFiles() {

        for (CsvFileConfiguration fileConfiguration : properties.getReader().getCsv()) {
            readFile(fileConfiguration.getName());
        }
    }

    @SneakyThrows
    private void readFile(String fileName) {

        log.info("Reading: {}", fileName);

        try (Reader in = new FileReader(fileName)) {

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(false)
                    .build();

            Iterable<CSVRecord> records = csvFormat.parse(in);

            ModelBuilder builder = new ModelBuilder();

            builder.setNamespace(RDFS.NS)
                .setNamespace(RDF.NS)
                .setNamespace(DCTERMS.NS)
                .setNamespace(SKOS.NS)
                .setNamespace(FOAF.NS);

            for (NamespaceConfiguration configuration : properties.getNamespaces()) {
                builder.setNamespace(configuration.getPrefix(), configuration.getUri());
            }

            for (CSVRecord record : records) {
                String subject = record.get("rdf:subject");
                builder.subject(subject);
                record.toMap().entrySet().stream().filter(e -> !e.getKey().equals("rdf:subject")).filter(e -> !e.getValue().isBlank()).forEach(e -> builder.add(trimIndex(e.getKey()), e.getValue()));
            }

            Model model = builder.build();

            RepositoryConnection connection = graph.getRepository().getConnection();
            connection.add(model);
        }
    }

    private String trimIndex(String predicate) {

        return predicate.replaceAll("\\[\\d*\\]", "");
    }
}

package com.dataqualityworks.migration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dataqualityworks.migration.readers.CsvReader;
import com.dataqualityworks.migration.writers.TtlWriter;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class RdfBuilderApplication implements CommandLineRunner {

    @Autowired
    private CsvReader csvReader;

    @Autowired
    private TtlWriter ttlWriter;

    public static void main(String[] args) {
        SpringApplication.run(RdfBuilderApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("Running RDF Builder.");
        csvReader.readFiles();
        ttlWriter.writeFiles();
        log.info("Done building RDF.");
    }
}

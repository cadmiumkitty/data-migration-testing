package com.dataqualityworks.migration.writers;

import java.io.FileWriter;
import java.io.Writer;

import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFHandler;
import org.eclipse.rdf4j.rio.Rio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dataqualityworks.migration.configuration.RdfBuilderConfigurationProperties;
import com.dataqualityworks.migration.graph.Graph;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TtlWriter {

    @Autowired
    private RdfBuilderConfigurationProperties properties;

    @Autowired
    private Graph graph;

    public void writeFiles() {

        log.info("Writing: {}", properties.getWriter().getTtl().getName());
        writeFile(properties.getWriter().getTtl().getName());
    }

    @SneakyThrows
    public void writeFile(String fileName) {

        try (Writer out = new FileWriter(fileName)) {
            RDFHandler turtleWriter = Rio.createWriter(RDFFormat.TURTLE, out);
            graph.getRepository().getConnection().export(turtleWriter);
        }
    }
}

package com.dataqualityworks.migration.graph;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.springframework.stereotype.Component;

@Component
public class Graph {
    
    private Repository repository = new SailRepository(new MemoryStore());

    public Repository getRepository() {
        
        return repository;
    }
}

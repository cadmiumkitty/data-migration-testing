package com.dataqualityworks.migration.telemetry;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dataqualityworks.migration.graph.Graph;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TelemetryProbe {
    
    @Autowired
    private Graph graph;

    private List<TelemetryEvent> events = new LinkedList<>();

    public void startSession() {
        events.clear();
    }

    public void flushSession(final Collection<String> tags) {
        List<TelemetryEvent> taggedEvents = events.stream().map(event -> event.toBuilder().tags(tags).build()).collect(Collectors.toList());
        log.info("Events: {}", taggedEvents);
    }

    public void recordEvent(TelemetryEvent event) {
        events.add(event);
    }
}

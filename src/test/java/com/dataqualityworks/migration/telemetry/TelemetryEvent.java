package com.dataqualityworks.migration.telemetry;

import java.util.Collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TelemetryEvent {
    private Collection<String> tags;
    private String outcome;
}

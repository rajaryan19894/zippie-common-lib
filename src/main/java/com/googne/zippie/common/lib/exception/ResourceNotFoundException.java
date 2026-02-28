package com.googne.zippie.common.lib.exception;

import java.util.Map;
import java.util.stream.Collectors;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String entityName, String entityId) {
        super(entityName + " not found for ID: " + entityId);
    }

    public ResourceNotFoundException(String entityName, Map<String, Object> finderMap) {
        super(buildMessage(entityName, finderMap));
    }

    private static String buildMessage(String entityName, Map<String, Object> finderMap) {
        if (finderMap == null || finderMap.isEmpty()) {
            return entityName + " not found";
        }

        // Convert map entries to "key=value" strings and join with comma
        String details = finderMap.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(", "));

        return entityName + " not found by [" + details + "]";
    }
}
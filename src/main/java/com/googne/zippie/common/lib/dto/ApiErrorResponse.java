package com.googne.zippie.common.lib.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.List;
import java.util.stream.Stream;

@Builder
public record ApiErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        List<String> stackTrace
) {

    public static List<String> extractStackTrace (Throwable ex){
        return Stream.of(ex.getStackTrace())
                .map(StackTraceElement::toString)
                .toList();
    }
}

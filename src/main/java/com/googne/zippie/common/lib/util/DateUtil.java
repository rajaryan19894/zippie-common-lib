package com.googne.zippie.common.lib.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.parse;

public class DateUtil {
    public static final String TIME_PATTERN_24H = "HH:mm:ss";       // 24-hour format, e.g., 18:30:45
    public static final String TIME_PATTERN_12H = "hh:mm:ss a";     // 12-hour format with AM/PM, e.g., 06:30:45 PM
    private static final String DATE_PATTERN = "dd-MM-yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static final DateTimeFormatter DATE_TIME_FORMATTER_24H =
            DateTimeFormatter.ofPattern(DATE_PATTERN + " " + TIME_PATTERN_24H);

    public static final DateTimeFormatter DATE_TIME_FORMATTER_12H =
            DateTimeFormatter.ofPattern(DATE_PATTERN + " " + TIME_PATTERN_12H);

    public static final DateTimeFormatter ENTITY_NUMBER_DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN.replace("-", "")); // e.g., "07022026"

    public static final DateTimeFormatter ENTITY_NUMBER_DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN.replace("-", "")
                    + "_" + TIME_PATTERN_24H.replace(":", "")); // e.g., "07022026183045"

    private static LocalDate nowDate() {
        return LocalDate.now();
    }

    private static LocalDateTime nowDateTime() {
        return LocalDateTime.now();
    }

    public static String keywordDate() {
        return nowDate().format(ENTITY_NUMBER_DATE_FORMATTER);
    }

    public static String keywordDateTime() {
        return nowDateTime().format(ENTITY_NUMBER_DATE_TIME_FORMATTER);
    }

    public static String todayDate() {
        return nowDate().format(DATE_FORMATTER);
    }

    /**
     * Returns current timestamp in 24-hour format
     */
    public static String nowDateTime24H() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER_24H);
    }

    /**
     * Returns current timestamp in 12-hour format with AM/PM
     */
    public static String nowDateTime12H() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER_12H);
    }

    // Format a LocalDate with custom pattern
    public static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    // Format a LocalDateTime with custom pattern
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    // Parse a string to LocalDate using a pattern
    public static LocalDate parseDate(String date, String pattern) {
        return parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    // Parse a string to LocalDateTime using a pattern
    public static LocalDateTime parseDateTime(String dateTime, String pattern) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
    }
}

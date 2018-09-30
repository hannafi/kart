package com.qarthinvest.kart.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static LocalDateTime utcDateTime() {
        return utcZoned().toLocalDateTime();
    }

    public static LocalDate utcDate() {
        return utcZoned().toLocalDate();
    }

    private static ZonedDateTime utcZoned() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }

    public static String id() {
        return UUID.randomUUID().toString();
    }

    public static boolean canUpdate(String input) {
        return !(input == null || "".equals(input.trim()));
    }

}
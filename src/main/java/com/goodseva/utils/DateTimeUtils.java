package com.goodseva.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static String getFutureDate(int days, String dateFormat) {
        // Get future date
        LocalDateTime futureDate = LocalDateTime.now().plusDays(days);

        // Define your desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        // Format the date
        return futureDate.format(formatter);
    }

    public static String getCurrentTime(String timeFormat) {
        // Get current time
        LocalTime currentTime = LocalTime.now();

        // Define format: hh = 12-hour, mm = minutes, a = AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
        // Format time
        return currentTime.format(formatter);
    }

    public static String getFutureTimeInMinutes(int mins, String timeFormat) {
        // Get current time
        LocalTime now = LocalTime.now();

        // Add minutes to get future time
        LocalTime futureTime = now.plusMinutes(mins);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
        return futureTime.format(formatter);
    }
}

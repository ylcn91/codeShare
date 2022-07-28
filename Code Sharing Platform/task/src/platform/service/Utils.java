package platform.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Utils {

    private static final String DATETIME_FORMAT = "yyy-MM-dd HH:mm:ss.SSS";

    public static String getCurrentDateTime() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
        return today.format(formatter);
    }

    public static String getNewUUID() {
        return UUID.randomUUID().toString();
    }

    public static long getMSecondsFromDate(String date) {
        SimpleDateFormat f = new SimpleDateFormat(DATETIME_FORMAT);
        try {
            return f.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

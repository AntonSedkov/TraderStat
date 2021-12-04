package by.anthony.traiderstat.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeConverter {
    private TimeConverter() {
        throw new UnsupportedOperationException("TimeConverter instance is forbidden");
    }

    public static Timestamp toTimestamp(LocalDateTime dateTime) {
        return Timestamp.valueOf(dateTime);
    }

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }

}
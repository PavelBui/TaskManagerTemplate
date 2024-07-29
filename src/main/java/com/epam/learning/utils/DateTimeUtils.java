package com.epam.learning.utils;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;

@UtilityClass
public class DateTimeUtils {

    public Long convertDateToTimestamp(LocalDateTime localDateTime) {
        if (Objects.nonNull(localDateTime)) {
            OffsetDateTime offsetDateTime = localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime();
            return localDateTime.toInstant(offsetDateTime.getOffset()).toEpochMilli();
        }
        return null;
    }

    public LocalDateTime convertTimestampToDate(Long timestamp) {
        if (Objects.nonNull(timestamp)) {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        }
        return null;
    }
}

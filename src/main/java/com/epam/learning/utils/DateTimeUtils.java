package com.epam.learning.utils;

import com.epam.learning.exeption.InvalidValidationException;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@UtilityClass
public class DateTimeUtils {

    public String convertDateToString(LocalDateTime localDateTime) {
        if (Objects.nonNull(localDateTime)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return localDateTime.format(dateTimeFormatter);
        } else {
            return null;
        }
    }

    public LocalDateTime convertStringToDate(String string) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(string, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            throw new InvalidValidationException("Date and time should be in the following format: (yyyy-MM-dd HH:mm)");
        }
    }
}

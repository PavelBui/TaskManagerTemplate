package com.epam.learning.utils;

import com.epam.learning.exeption.InvalidValidationException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeUtilsTest {

    @Test
    void convertDateToStringWithCorrectInputTest() {
        // given
        LocalDateTime localDateTime = LocalDateTime.of(2024, 7, 19, 11, 20);

        // when
        String result = DateTimeUtils.convertDateToString(localDateTime);

        // then
        assertEquals("2024-07-19 11:20", result);
    }

    @Test
    void convertDateToStringWithNullInputTest() {
        // when
        String result = DateTimeUtils.convertDateToString(null);

        // then
        assertNull(result);
    }

    @Test
    void convertStringToDateWithCorrectInputTest() {
        // given
        String string = "2024-07-19 11:20";

        // when
        LocalDateTime result = DateTimeUtils.convertStringToDate(string);

        // then
        assertEquals("2024-07-19T11:20", result.toString());
    }

    @Test
    void convertStringToDateWithIncorrectInputTest() {
        // given
        String string = "2024:07:19";

        // then
        assertThrows(InvalidValidationException.class, () -> DateTimeUtils.convertStringToDate(string));
    }
}
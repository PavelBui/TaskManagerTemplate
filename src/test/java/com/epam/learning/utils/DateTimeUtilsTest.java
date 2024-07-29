package com.epam.learning.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeUtilsTest {

    @Test
    void convertDateToTimestampWithCorrectInputTest() {
        // given
        LocalDateTime localDateTime = LocalDateTime.of(2024, 7, 19, 11, 20);

        // when
        Long result = DateTimeUtils.convertDateToTimestamp(localDateTime);

        // then
        assertEquals(1721377200000L, result);
    }

    @Test
    void convertDateToTimestampWithNullInputTest() {
        // when
        Long result = DateTimeUtils.convertDateToTimestamp(null);

        // then
        assertNull(result);
    }

    @Test
    void convertTimestampToDateWithCorrectInputTest() {
        // given
        Long timestamp = 1721377200000L;

        // when
        LocalDateTime result = DateTimeUtils.convertTimestampToDate(timestamp);

        // then
        assertEquals("2024-07-19T11:20", result.toString());
    }

    @Test
    void convertTimestampToDateWithIncorrectInputTest() {
        // then
        LocalDateTime result = DateTimeUtils.convertTimestampToDate(null);

        assertNull(result);
    }
}
package com.zero.euler.level001;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Slf4j
public class A19CountingSundays {

    public static void main(String[] args) {
        log.info("How many sundays fell on the first month 1901 - 2000: {}", count());
    }

    public static int count() {
        int count = 0;

        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                LocalDate date = LocalDate.of(year, month, 1);
                if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    count++;
                }
            }
        }

        return count;
    }

}

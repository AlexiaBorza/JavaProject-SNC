package com.backend.model.response;
import java.time.LocalDate;

public class Utils {
    public static int getYear() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();

        if (month > 7) {
            return year - 1;
        } else {
            return year - 2;
        }
    }
}
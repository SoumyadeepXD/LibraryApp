package model;

import java.time.temporal.ChronoUnit;

public class FineCalculator {
    private static final int LIMIT_DAYS = 14;
    private static final double FINE_PER_DAY = 2.0;

    public static double calculateFine(Transaction t) {
        if (t.returnDate == null) return 0;

        long days = ChronoUnit.DAYS.between(t.issueDate, t.returnDate);

        if (days <= LIMIT_DAYS) return 0;

        return (days - LIMIT_DAYS) * FINE_PER_DAY;
    }
}// Auto-generated file: FineCalculator.java
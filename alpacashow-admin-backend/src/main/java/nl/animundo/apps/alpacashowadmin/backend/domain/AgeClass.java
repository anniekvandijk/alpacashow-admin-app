package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum AgeClass {

    JUNIOR (6, 12),
    INTERMEDIATE (12, 24),
    ADULT (24, 48),
    SENIOR (48, 72),
    MATURE (72, 600);

    private static Logger logger = LoggerFactory.getLogger(AgeClass.class);

    private final int monthMin;
    private final int monthMax;

    AgeClass(final int monthMin, final int monthMax) {
        this.monthMin = monthMin;
        this.monthMax = monthMax;
    }

    public static AgeClass getAgeClassHaltershow(final LocalDate showDate, final LocalDate dateOfBirth) {

        long ageInMonths = getAgeInMonthHaltershow(showDate, dateOfBirth);

        if (ageInMonths >= 0 && ageInMonths < 6) {
            throw new IllegalArgumentException("Animals under the age of 6 can not participate.");
        }
        if (ageInMonths >= 600 ) {
            throw new IllegalArgumentException("Animal age to high. Check the date of birth.");
        }

        for (AgeClass ageClass : AgeClass.values()) {
            if (ageInMonths >= ageClass.monthMin && ageInMonths < ageClass.monthMax) {
                logger.info("AgeClass = " + ageClass);
                return ageClass;
            }
        }
        // If enums are changed, code will break. Throw exeption.
        throw new RuntimeException("Unable to determen AgeClass, for given showDate '" + showDate + "' and dateOfBirth '" + dateOfBirth + "'");
    }

    public static long getAgeInMonthHaltershow(final LocalDate showDate, final LocalDate dateOfBirth) {

        final long ageInMonths = ChronoUnit.MONTHS.between(dateOfBirth, showDate);
        logger.info("Age in months = " + ageInMonths);

        if (ageInMonths < 0 ) {
            throw new IllegalArgumentException("Age below zero months. Check date of birth.");
        }
        else {
            return ageInMonths;

        }

    }
}

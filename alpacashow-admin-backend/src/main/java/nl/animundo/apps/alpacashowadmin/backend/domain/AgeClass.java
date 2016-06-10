package nl.animundo.apps.alpacashowadmin.backend.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Anniek van Dijk on 7-6-2016.
 */
public enum AgeClass {

    JUNIOR (6, 12),
    INTERMEDIATE (12, 24),
    ADULT (24, 48),
    SENIOR (48, 72),
    MATURE (72, 1000);

    private final int monthMin;
    private final int monthMax;

    AgeClass(final int monthMin, final int monthMax) {
        this.monthMin = monthMin;
        this.monthMax = monthMax;
    }

    public static AgeClass getAgeClass(final LocalDate showDate, final LocalDate dateOfBirth) {

        long ageInMonths = getAgeInMonths(showDate, dateOfBirth);

        for (AgeClass ageClass : AgeClass.values()) {
            if (ageInMonths >= ageClass.monthMin && ageInMonths < ageClass.monthMax) {
                return ageClass;
            }
        }

        throw new RuntimeException("Unable to determen AgeClass, for given showDate '" + showDate + "' and dateOfBirth '" + dateOfBirth + "'");
    }

    public static long getAgeInMonths(LocalDate showDate, LocalDate dateOfBirth) {

        final long ageInMonths = ChronoUnit.MONTHS.between(dateOfBirth, showDate);

        if (ageInMonths < 0 ) {
            throw new IllegalArgumentException("Age below zero months. Check date of birth.");
        }
         else if (ageInMonths >= 0 & ageInMonths < 6) {
            throw new IllegalArgumentException("Animals under the age of 6 can not participate");
        }
        else {
            return ageInMonths;
        }

    }
}

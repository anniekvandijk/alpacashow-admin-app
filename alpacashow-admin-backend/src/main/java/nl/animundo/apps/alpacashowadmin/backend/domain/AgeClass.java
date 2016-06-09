package nl.animundo.apps.alpacashowadmin.backend.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Anniek van Dijk on 7-6-2016.
 */
public enum AgeClass {

    JUNIOR ("Junior"),
    INTERMEDIATE ("Intermediate"),
    ADULT ("Adult"),
    SENIOR ("Senior"),
    MATURE ("Mature");

    private final String ageClassName;

    AgeClass(String ageClassName) {
        this.ageClassName = ageClassName;
    }

    public String getAgeClassName() {
        return ageClassName;
    }

    public static String getAgeClass(LocalDate showDate, LocalDate dateOfBirth) {

        long ageInMonths = getAgeInMonths(showDate, dateOfBirth);

        Enum ageClass = null;

        // TODO Can we use LongSgtream? LongStream.range(6, 12);

        if (ageInMonths >= 6 & ageInMonths < 12) {
            ageClass = AgeClass.JUNIOR;
        } else if (ageInMonths >= 12 & ageInMonths < 24) {
            ageClass = AgeClass.INTERMEDIATE;
        } else if (ageInMonths >= 24 & ageInMonths < 48) {
            ageClass = AgeClass.ADULT;
        } else if (ageInMonths >= 48 & ageInMonths < 72) {
            ageClass = AgeClass.SENIOR;
        } else if (ageInMonths >= 72) {
            ageClass = AgeClass.MATURE;
        }
        return String.valueOf(ageClass);
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

package nl.animundo.apps.alpacashowadmin.backend.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Anniek van Dijk on 7-6-2016.
 */
public enum AgeClass {

    JUNIOR,
    INTERMEDIATE,
    ADULT,
    SENIOR,
    MATURE;

    public static String getAgeClass(LocalDate showDate, LocalDate dateOfBirth) {

        long ageInMonths = getAgeInMonths(showDate, dateOfBirth);

        Enum ageClass = null;

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
            throw new IllegalArgumentException("Leeftijd onder de 0 maanden. Controleer de geboortedatum.");
        }
         else if (ageInMonths >= 0 & ageInMonths < 6) {
            throw new IllegalArgumentException("Dieren onder de 6 maanden mogen niet deelnemen");
        }
        else {
            return ageInMonths;
        }

    }
}

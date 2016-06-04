package nl.animundo.apps.alpacashowadmin.backend.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */

public class AgeClassService {


    // TODO Error als ageInMonths onder de 0 komt.
    // TODO Melding te jong als ageInMonths onder de 6 komt.
    // TODO Een max stellen aan de leeftijd in maanden?

    public static String getAgeClass(int ageInMonths) {

        String ageClass = "";

        if (ageInMonths >= 0 & ageInMonths < 6 ) {
            return "To young!";
        }
        else if (ageInMonths >= 6 & ageInMonths < 12 ) {
            return "Junior";
        }
        else if (ageInMonths >= 12 & ageInMonths < 24 ) {
            return "Intermediate";
        }
        else if (ageInMonths >= 24 & ageInMonths < 48 ) {
            return "Adult";
        }
        else if (ageInMonths >= 48 & ageInMonths < 72) {
            return "Senior";
        }
        else if (ageInMonths >= 72 ) {
            return "Mature";
        }
        else {
            return "Error!";
        }
    }

    public static long getAgeInMonths(LocalDate showDate, LocalDate dateOfBirth) {

        return ChronoUnit.MONTHS.between(dateOfBirth, showDate);

    }
}

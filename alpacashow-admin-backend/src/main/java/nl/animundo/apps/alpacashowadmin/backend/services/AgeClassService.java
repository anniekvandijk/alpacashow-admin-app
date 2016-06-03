package nl.animundo.apps.alpacashowadmin.backend.services;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AgeClassService {

    public static String ageClass;
    public static int ageInMonths;

    public static String getAgeClass(int ageInMonths) {

        if (ageInMonths < 0 ) {
            return "Error!";
        }
        else if (ageInMonths >= 0 && ageInMonths < 6 ) {
            return "To young!";
        }
        else if (ageInMonths >= 6 && ageInMonths < 12 ) {
            return "Junior";
        }
        else if (ageInMonths >= 12 && ageInMonths < 24 ) {
            return "Intermediate";
        }
        else if (ageInMonths >= 24 && ageInMonths < 48 ) {
            return "Adult";
        }
        else if (ageInMonths >= 48 && ageInMonths < 72) {
            return "Senior";
        }
        else if (ageInMonths >= 72 ) {
            return "Mature";
        }
        return ageClass;
    }

    public static int getAgeInMonths(LocalDate showDate, LocalDate dateOfBirth) {

        int showMonth = showDate.getMonthValue();
        int dateOfBirthMonth = dateOfBirth.getMonthValue();
        int showDayOfMonth = showDate.getDayOfMonth();
        int dateofBirthDayOfMonth = dateOfBirth.getDayOfMonth();

        ageInMonths = Math.abs(dateOfBirthMonth - showMonth);

        if (dateofBirthDayOfMonth > showDayOfMonth) {
            ageInMonths = ageInMonths -1 ;
            return ageInMonths;
        }
        else if ( ageInMonths < 0 ) {
            ageInMonths = ageInMonths + 1 ;
            return ageInMonths;
        }
        else  {
            return ageInMonths;
        }

        // TODO Error als ageInMonths onder de 0 komt.
        // TODO Melding te jong als ageInMonths onder de 6 komt.

    }
}

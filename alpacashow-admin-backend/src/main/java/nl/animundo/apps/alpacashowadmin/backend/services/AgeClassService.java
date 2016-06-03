package nl.animundo.apps.alpacashowadmin.backend.services;

import java.time.LocalDate;

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

        int showYear = showDate.getYear();
        int dateOfBirthYear = dateOfBirth.getYear();

        int showMonth = showDate.getMonthValue();
        int dateOfBirthMonth = dateOfBirth.getMonthValue();

        int showDayOfMonth = showDate.getDayOfMonth();
        int dateofBirthDayOfMonth = dateOfBirth.getDayOfMonth();

        int yearDiff = showYear - dateOfBirthYear;
        int monthDiff = dateOfBirthMonth - showMonth;

        System.out.println(String.format("---------"));
        System.out.println(String.format("showYear: %d", showYear));
        System.out.println(String.format("dateOfBirthYear: %d", dateOfBirthYear));

        System.out.println(String.format("showMonth: %d", showMonth));
        System.out.println(String.format("dateOfBirthMonth: %d", dateOfBirthMonth));

        System.out.println(String.format("showDayOfMonth: %d", showDayOfMonth));
        System.out.println(String.format("dateofBirthDayOfMonth: %d", dateofBirthDayOfMonth));

        System.out.println(String.format("yearDiff: %d", yearDiff));
        System.out.println(String.format("monthDiff: %d", monthDiff));

        if (dateofBirthDayOfMonth > showDayOfMonth) {
            monthDiff = monthDiff -1 ;
            System.out.println(String.format("ageInMonths -1: %d", monthDiff));
        }
        else if ( monthDiff < 0 ) {
            monthDiff = monthDiff + 1 ;
            System.out.println(String.format("ageInMonths + 1: %d", monthDiff));
        }
        else  {
            System.out.println(String.format("ageInMonths: %d", monthDiff));
        }

        return ( yearDiff * 12 ) + monthDiff;

        // TODO Error als ageInMonths onder de 0 komt.
        // TODO Melding te jong als ageInMonths onder de 6 komt.
    }
}

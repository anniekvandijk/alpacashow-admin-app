package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AgeClassServiceAgeClassTest {

    // Onder 6 maanden uitgesloten van deelname
    // 6-11 maanden JUNIOR
    // 12-23 maanden INTERMEDIATE
    // 24-47 ADULT
    // 48-71 SENIOR
    // 72-...MATURE

    @Test
    public void AgeClassLess0Months() {

        int ageInMonths = 0;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("To young", AgeClassService.getAgeClass());
    }

    @Test
    public void AgeClass5Months() {

        int ageInMonths = 5;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("To Joung", AgeClassService.getAgeClass());
    }

    @Test
    public void AgeClas6Months() {

        int ageInMonths = 6;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Junior", AgeClassService.getAgeClass());
    }

    @Test
    public void AgeClass11Months() {

        int ageInMonths = 11;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Junior", AgeClassService.getAgeClass());
    }

    @Test
    public void AgeClass12Months() {

        int ageInMonths = 12;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Intermediate", AgeClassService.getAgeClass());
    }

    @Test
    public void AgeClass23Months() {

        int ageInMonths = 23;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Intermediate", AgeClassService.getAgeClass());
    }

    @Test
    public void AgeClass24Months() {

        int ageInMonths = 24;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Adult", AgeClassService.getAgeClass());
    }

    @Test
    public void AgeClass47Months() {

        int ageInMonths = 47;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Adult", AgeClassService.getAgeClass());

    }

    @Test
    public void AgeClass48Months() {

        int ageInMonths = 48;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Senior", AgeClassService.getAgeClass());

    }

    @Test
    public void AgeClass71Months() {

        int ageInMonths = 71;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Senior", AgeClassService.getAgeClass());

    }

    @Test
    public void AgeClass72Months() {

        int ageInMonths = 72;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Mature", AgeClassService.getAgeClass());
    }

    @Test
    public void AgeClass101Months() {

        int ageInMonths = 101;
        AgeClassService.setAgeInMonths(ageInMonths);
        assertEquals("Mature", AgeClassService.getAgeClass());

    }
}

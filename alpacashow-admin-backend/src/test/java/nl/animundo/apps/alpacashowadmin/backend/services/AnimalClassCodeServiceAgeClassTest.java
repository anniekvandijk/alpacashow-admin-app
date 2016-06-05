package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceAgeClassTest {

    // TODO Input die niet mag

    @Test
    public void AgeClassLessThan0() {

        int ageInMonths = -1;
        assertEquals("Error!", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClassLess0Months() {

        int ageInMonths = 0;
        assertEquals("To young!", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass5Months() {

        int ageInMonths = 5;
        assertEquals("To young!", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClas6Months() {

        int ageInMonths = 6;
        assertEquals("Junior", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass11Months() {

        int ageInMonths = 11;
        assertEquals("Junior", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass12Months() {

        int ageInMonths = 12;
        assertEquals("Intermediate", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass23Months() {

        int ageInMonths = 23;
        assertEquals("Intermediate", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass24Months() {

        int ageInMonths = 24;
        assertEquals("Adult", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass47Months() {

        int ageInMonths = 47;
        assertEquals("Adult", AnimalClassCodeService.getAgeClass(ageInMonths));

    }

    @Test
    public void AgeClass48Months() {

        int ageInMonths = 48;
        assertEquals("Senior", AnimalClassCodeService.getAgeClass(ageInMonths));

    }

    @Test
    public void AgeClass71Months() {

        int ageInMonths = 71;
        assertEquals("Senior", AnimalClassCodeService.getAgeClass(ageInMonths));

    }

    @Test
    public void AgeClass72Months() {

        int ageInMonths = 72;
        assertEquals("Mature", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass101Months() {

        int ageInMonths = 101;
        assertEquals("Mature", AnimalClassCodeService.getAgeClass(ageInMonths));

    }
}

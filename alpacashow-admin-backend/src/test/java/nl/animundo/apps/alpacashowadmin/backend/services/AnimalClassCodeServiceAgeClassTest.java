package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceAgeClassTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void AgeClassLessThan0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Leeftijd onder de 0 maanden. Controleer de geboortedatum.");

        int ageInMonths = -1;
        AnimalClassCodeService.getAgeClass(ageInMonths);
    }

    @Test
    public void AgeClass0Months() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Dieren onder de 6 maanden mogen niet deelnemen");

        int ageInMonths = 0;
        AnimalClassCodeService.getAgeClass(ageInMonths);
    }

    @Test
    public void AgeClass5Months() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Dieren onder de 6 maanden mogen niet deelnemen");

        int ageInMonths = 5;
        AnimalClassCodeService.getAgeClass(ageInMonths);
    }

    @Test
    public void AgeClas6Months() {

        int ageInMonths = 6;
        assertEquals("JUNIOR", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass11Months() {

        int ageInMonths = 11;
        assertEquals("JUNIOR", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass12Months() {

        int ageInMonths = 12;
        assertEquals("INTERMEDIATE", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass23Months() {

        int ageInMonths = 23;
        assertEquals("INTERMEDIATE", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass24Months() {

        int ageInMonths = 24;
        assertEquals("ADULT", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass47Months() {

        int ageInMonths = 47;
        assertEquals("ADULT", AnimalClassCodeService.getAgeClass(ageInMonths));

    }

    @Test
    public void AgeClass48Months() {

        int ageInMonths = 48;
        assertEquals("SENIOR", AnimalClassCodeService.getAgeClass(ageInMonths));

    }

    @Test
    public void AgeClass71Months() {

        int ageInMonths = 71;
        assertEquals("SENIOR", AnimalClassCodeService.getAgeClass(ageInMonths));

    }

    @Test
    public void AgeClass72Months() {

        int ageInMonths = 72;
        assertEquals("MATURE", AnimalClassCodeService.getAgeClass(ageInMonths));
    }

    @Test
    public void AgeClass101Months() {

        int ageInMonths = 101;
        assertEquals("MATURE", AnimalClassCodeService.getAgeClass(ageInMonths));

    }
}

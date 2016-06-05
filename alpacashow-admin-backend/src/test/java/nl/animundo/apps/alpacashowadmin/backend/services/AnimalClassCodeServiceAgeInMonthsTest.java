package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceAgeInMonthsTest {

    LocalDate showDate;
    LocalDate dateOfBirth;

    @Test
    public void AgeInMonthsBelow0() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 6, 15);
        assertEquals(-1, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths0() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 5, 15);
        assertEquals(0, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsAlso0() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 4, 16);
        assertEquals(0, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths6MinusOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015, 11, 16);
        assertEquals(5, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths18Months() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2015, 5, 1);
        assertEquals(18, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12MinusOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015, 5, 16);
        assertEquals(11, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015,5,15);
        assertEquals(12, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12andOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015,5,14);
        assertEquals(12, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsJust12() {

        showDate = LocalDate.of(2016,5,30);
        dateOfBirth = LocalDate.of(2015,5,15);
        assertEquals(12, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate12() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,2,28);
        assertEquals(12, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate11() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,3,1);
        assertEquals(11, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth12() {

        showDate = LocalDate.of(2017,3,1);
        dateOfBirth = LocalDate.of(2016,2,29);
        assertEquals(12, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth11() {

        showDate = LocalDate.of(2017, 3, 28);
        dateOfBirth = LocalDate.of(2016, 2, 29);
        assertEquals(12, AnimalClassCodeService.getAgeInMonths(showDate, dateOfBirth));
    }
}

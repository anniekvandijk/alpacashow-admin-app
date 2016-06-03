package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AgeClassServiceAgeInMonthsTest {

    LocalDate showDate;
    LocalDate dateOfBirth;

    @Test
    public void AgeInMonths12MinusOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 5, 16);
        AgeClassService.calculateAgeInMonths(showDate, dateOfBirth);
        assertEquals(11, AgeClassService.getAgeInMonths);
    }

    @Test
    public void AgeInMonths12() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016,5,15);
        AgeClassService.calculateAgeInMonths(showDate, dateOfBirth);
        assertEquals(12, AgeClassService.getAgeInMonths);
    }

    @Test
    public void AgeInMonths12andOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016,5,14);
        AgeClassService.calculateAgeInMonths(showDate, dateOfBirth);
        assertEquals(12, AgeClassService.getAgeInMonths);
    }

    @Test
    public void AgeInMonthsJust12() {

        showDate = LocalDate.of(2016,4,30);
        dateOfBirth = LocalDate.of(2016,5,15);
        AgeClassService.calculateAgeInMonths(showDate, dateOfBirth);
        assertEquals(12, AgeClassService.getAgeInMonths);
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate12() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2016,2,28);
        AgeClassService.calculateAgeInMonths(showDate, dateOfBirth);
        assertEquals(12, AgeClassService.getAgeInMonths);
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate11() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2016,3,1);
        AgeClassService.calculateAgeInMonths(showDate, dateOfBirth);
        assertEquals(12, AgeClassService.getAgeInMonths);
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth12() {

        showDate = LocalDate.of(2016,3,30);
        dateOfBirth = LocalDate.of(2016,2,29);
        AgeClassService.calculateAgeInMonths(showDate, dateOfBirth);
        assertEquals(12, AgeClassService.getAgeInMonths);
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth11() {

        showDate = LocalDate.of(2016,3,28);
        dateOfBirth = LocalDate.of(2016,2,29);
        AgeClassService.calculateAgeInMonths(showDate, dateOfBirth);
        assertEquals(12, AgeClassService.getAgeInMonths);
    }
}

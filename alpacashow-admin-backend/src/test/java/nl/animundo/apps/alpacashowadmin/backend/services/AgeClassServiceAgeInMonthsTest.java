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
    public void AgeInMonthsBelow0() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 5, 16);
        assertEquals(-1, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths0() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 5, 15);
        assertEquals(0, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths6MinusOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015, 11, 16);
        assertEquals(5, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12MinusOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015, 5, 16);
        assertEquals(11, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015,5,15);
        assertEquals(12, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12andOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015,5,14);
        assertEquals(12, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsJust12() {

        showDate = LocalDate.of(2016,4,30);
        dateOfBirth = LocalDate.of(2015,5,15);
        assertEquals(12, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate12() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,2,28);
        assertEquals(12, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate11() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,3,1);
        assertEquals(12, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth12() {

        showDate = LocalDate.of(2017,3,30);
        dateOfBirth = LocalDate.of(2016,2,29);
        assertEquals(12, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth11() {

        showDate = LocalDate.of(201,3,28);
        dateOfBirth = LocalDate.of(2016,2,29);
        assertEquals(12, AgeClassService.getAgeInMonths(showDate, dateOfBirth));
    }
}

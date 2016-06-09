package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AgeClassTest {

    LocalDate showDate;
    LocalDate dateOfBirth;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void junior() {

        assertEquals("Junior", AgeClass.JUNIOR.getAgeClassName());
    }

    @Test
    public void intermediate() {

        assertEquals("Intermediate", AgeClass.INTERMEDIATE.getAgeClassName());
    }

    @Test
    public void adult() {

        assertEquals("Adult", AgeClass.ADULT.getAgeClassName());
    }

    @Test
    public void senior() {

        assertEquals("Senior", AgeClass.SENIOR.getAgeClassName());
    }

    @Test
    public void mature() {

        assertEquals("Mature", AgeClass.MATURE.getAgeClassName());
    }

    @Test
    public void AgeInMonthsBelow0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Age below zero months. Check date of birth.");

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 6, 15);
        AgeClass.getAgeInMonths(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under the age of 6 can not participate");

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 5, 15);
        AgeClass.getAgeInMonths(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonthsAlso0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under the age of 6 can not participate");

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2016, 4, 16);
        AgeClass.getAgeInMonths(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths6MinusOneDay() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under the age of 6 can not participate");

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015, 11, 16);
        AgeClass.getAgeInMonths(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths6() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015, 11, 14);
        assertEquals(6, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("JUNIOR", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths7() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015, 10, 14);
        assertEquals(7, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("JUNIOR", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12MinusOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015, 5, 16);
        assertEquals(11, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("JUNIOR", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate11() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,3,1);
        assertEquals(11, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("JUNIOR", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015,5,15);
        assertEquals(12, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12andOneDay() {

        showDate = LocalDate.of(2016,5,15);
        dateOfBirth = LocalDate.of(2015,5,14);
        assertEquals(12, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsJust12() {

        showDate = LocalDate.of(2016,5,30);
        dateOfBirth = LocalDate.of(2015,5,15);
        assertEquals(12, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate12() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,2,28);
        assertEquals(12, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth12() {

        showDate = LocalDate.of(2017,3,1);
        dateOfBirth = LocalDate.of(2016,2,29);
        assertEquals(12, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth11() {

        showDate = LocalDate.of(2017, 3, 28);
        dateOfBirth = LocalDate.of(2016, 2, 29);
        assertEquals(12, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths13() {

        showDate = LocalDate.of(2016,5,30);
        dateOfBirth = LocalDate.of(2015,4,15);
        assertEquals(13, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths18Months() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2015, 5, 1);
        assertEquals(18, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths23() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2014, 12, 1);
        assertEquals(23, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("INTERMEDIATE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths24() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2014, 11, 14);
        assertEquals(24, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("ADULT", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths25() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2014, 10, 14);
        assertEquals(25, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("ADULT", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths47() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2012, 11, 16);
        assertEquals(47, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("ADULT", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths48() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2012, 11, 14);
        assertEquals(48, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("SENIOR", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths49() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2012, 10, 14);
        assertEquals(49, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("SENIOR", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths71() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2010, 11, 30);
        assertEquals(71, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("SENIOR", AgeClass.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths72() {

        showDate = LocalDate.of(2016,11,15);
        dateOfBirth = LocalDate.of(2010, 10, 30);
        assertEquals(72, AgeClass.getAgeInMonths(showDate, dateOfBirth));
        assertEquals("MATURE", AgeClass.getAgeClass(showDate, dateOfBirth));
    }
}

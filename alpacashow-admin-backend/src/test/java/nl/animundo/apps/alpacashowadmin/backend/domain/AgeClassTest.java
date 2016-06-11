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
    public void AgeInMonthsBelow0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Age below zero months. Check date of birth.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().plusMonths(1);
        AgeClass.getAgeInMonthHaltershow(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under the age of 6 can not participate");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now();
        AgeClass.getAgeClassHaltershow(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonthsAlso0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under the age of 6 can not participate");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(1).plusDays(1);
        AgeClass.getAgeClassHaltershow(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths6MinusOneDay() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under the age of 6 can not participate");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(6).plusDays(1);
        AgeClass.getAgeClassHaltershow(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths6() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(6);
        assertEquals(AgeClass.JUNIOR, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths7() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(7);
        assertEquals(AgeClass.JUNIOR, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12MinusOneDay() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12).plusDays(1);
        assertEquals(AgeClass.JUNIOR, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate11() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,3,1);
        assertEquals(AgeClass.JUNIOR, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12);
        assertEquals(AgeClass.INTERMEDIATE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12andOneDay() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12).minusDays(1);
        assertEquals(AgeClass.INTERMEDIATE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate12() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,2,28);
        assertEquals(AgeClass.INTERMEDIATE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth12() {

        showDate = LocalDate.of(2017,3,1);
        dateOfBirth = LocalDate.of(2016,2,29);
        assertEquals(AgeClass.INTERMEDIATE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth11() {

        showDate = LocalDate.of(2017, 3, 28);
        dateOfBirth = LocalDate.of(2016, 2, 29);
        assertEquals(AgeClass.INTERMEDIATE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths13() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(13);
        assertEquals(AgeClass.INTERMEDIATE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths18Months() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(18);
        assertEquals(AgeClass.INTERMEDIATE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths23() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(23);
        assertEquals(AgeClass.INTERMEDIATE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths24() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(24);
        assertEquals(AgeClass.ADULT, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths25() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(25);
        assertEquals(AgeClass.ADULT, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths47() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(47);
        assertEquals(AgeClass.ADULT, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths48() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(48);
        assertEquals(AgeClass.SENIOR, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths49() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(49);
        assertEquals(AgeClass.SENIOR, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths71() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(71);
        assertEquals(AgeClass.SENIOR, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths72() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(72);
        assertEquals(AgeClass.MATURE, AgeClass.getAgeClassHaltershow(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths600() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animal age to high. Check the date of birth.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(600);
        AgeClass.getAgeClassHaltershow(showDate, dateOfBirth);
    }
}

package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.time.LocalDate;

public class AgeClassServiceTest {

    private LocalDate showDate;
    private LocalDate dateOfBirth;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noInstanceTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        exception.expect(InstantiationException.class);
        exception.expectMessage("Instances of this type are forbidden!");

        Constructor<AgeClassService> constructor = AgeClassService.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);

        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            throw (InstantiationException) e.getTargetException();
        }

        constructor.setAccessible(false);

    }

    @Test
    public void AgeInMonthsBelow0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Age below zero months. Check date of birth.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().plusMonths(1);
        AgeClassService.getAgeClass(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now();
        AgeClassService.getAgeClass(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonthsAlso0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(1).plusDays(1);
        AgeClassService.getAgeClass(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths1() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(2).plusDays(1);
        AgeClassService.getAgeClass(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths1too() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(1);
        AgeClassService.getAgeClass(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths5() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(5);
        Assert.assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths6MinusOneDay() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(6).plusDays(1);
        AgeClassService.getAgeClass(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths6() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(6);
        Assert.assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths7() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(7);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

   @Test
    public void AgeInMonths10() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(10);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths11() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(11);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths13() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(13);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths22() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(22);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths23() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(23);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths24() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(24);
        assertEquals(AgeClass.ADULT, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths25() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(25);
        assertEquals(AgeClass.ADULT, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths46() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(46);
        assertEquals(AgeClass.ADULT, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths47() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(47);
        assertEquals(AgeClass.ADULT, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths48() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(48);
        assertEquals(AgeClass.SENIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths49() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(49);
        assertEquals(AgeClass.SENIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths70() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(71);
        assertEquals(AgeClass.SENIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths71() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(71);
        assertEquals(AgeClass.SENIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths72() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(72);
        assertEquals(AgeClass.MATURE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths73() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(73);
        assertEquals(AgeClass.MATURE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths599() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(599);
        assertEquals(AgeClass.MATURE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths600() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animal age to high. Check the date of birth.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(600);
        AgeClassService.getAgeClass(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths601() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animal age to high. Check the date of birth.");

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(601);
        AgeClassService.getAgeClass(showDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths12MinusOneDay() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12).plusDays(1);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate11() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,3,1);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12andOneDay() {

        showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12).minusDays(1);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate12() {

        showDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,2,28);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth12() {

        showDate = LocalDate.of(2017,3,1);
        dateOfBirth = LocalDate.of(2016,2,29);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth11() {

        showDate = LocalDate.of(2017, 3, 28);
        dateOfBirth = LocalDate.of(2016, 2, 29);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDate, dateOfBirth));
    }


}

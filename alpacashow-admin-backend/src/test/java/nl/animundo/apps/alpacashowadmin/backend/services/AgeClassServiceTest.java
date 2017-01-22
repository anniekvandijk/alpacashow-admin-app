package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
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

    private LocalDate showDateOrSheerDate;
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

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().plusMonths(1);
        AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now();
        AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth);
    }

    @Test
    public void AgeInMonthsAlso0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(1).plusDays(1);
        AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths1() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(2).plusDays(1);
        AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths1too() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(1);
        AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths5() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(5);
        Assert.assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths6MinusOneDay() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animals under 6 months can not participate.");

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(6).plusDays(1);
        AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths6() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(6);
        Assert.assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths7() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(7);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

   @Test
    public void AgeInMonths10() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(10);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths11() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(11);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths13() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(13);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths22() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(22);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths23() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(23);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths24() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(24);
        assertEquals(AgeClass.ADULT, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths25() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(25);
        assertEquals(AgeClass.ADULT, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths46() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(46);
        assertEquals(AgeClass.ADULT, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths47() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(47);
        assertEquals(AgeClass.ADULT, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths48() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(48);
        assertEquals(AgeClass.SENIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths49() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(49);
        assertEquals(AgeClass.SENIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths70() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(71);
        assertEquals(AgeClass.SENIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths71() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(71);
        assertEquals(AgeClass.SENIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths72() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(72);
        assertEquals(AgeClass.MATURE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths73() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(73);
        assertEquals(AgeClass.MATURE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths599() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(599);
        assertEquals(AgeClass.MATURE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths600() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animal age to high. Check the date of birth.");

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(600);
        AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths601() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animal age to high. Check the date of birth.");

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(601);
        AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth);
    }

    @Test
    public void AgeInMonths12MinusOneDay() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12).plusDays(1);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate11() {

        showDateOrSheerDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,3,1);
        assertEquals(AgeClass.JUNIOR, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonths12andOneDay() {

        showDateOrSheerDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusMonths(12).minusDays(1);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarShowDate12() {

        showDateOrSheerDate = LocalDate.of(2016,2,29);
        dateOfBirth = LocalDate.of(2015,2,28);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth12() {

        showDateOrSheerDate = LocalDate.of(2017,3,1);
        dateOfBirth = LocalDate.of(2016,2,29);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void AgeInMonthsSchrikkeljaarDateOfBrth11() {

        showDateOrSheerDate = LocalDate.of(2017, 3, 28);
        dateOfBirth = LocalDate.of(2016, 2, 29);
        assertEquals(AgeClass.INTERMEDIATE, AgeClassService.getAgeClass(showDateOrSheerDate, dateOfBirth));
    }

    @Test
    public void ShowDateOrSheerDate () {

        ShowType showType1  = ShowType.FLEECESHOW;
        ShowType showType2  = ShowType.HALTERSHOW;
        LocalDate showDate  = LocalDate.now();
        dateOfBirth         = LocalDate.now().minusYears(1);
        LocalDate sheerDate = LocalDate.now().minusMonths(2);

        ShowEvent showEvent1 = new ShowEvent("Show", showDate, LocalDate.now().minusMonths(6), "somewhere", "judge", showType1);
        ShowEvent showEvent2 = new ShowEvent("Show", showDate, LocalDate.now().minusMonths(6), "somewhere", "judge", showType2);
        Animal animal = new Animal("Animal", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.WHITE, dateOfBirth, "1", null, "dad", "mom", new ShowEventAnimalDetail(sheerDate, null));

        AgeClass ageClassFleeceShow = AgeClassService.ageClass(showEvent1, animal);
        assertEquals(AgeClass.JUNIOR, ageClassFleeceShow);
        AgeClass ageClassHalterShow = AgeClassService.ageClass(showEvent2, animal);
        assertEquals(AgeClass.INTERMEDIATE, ageClassHalterShow);

    }

    @Test
    public void SheerDateBeforeDateOfBirth () {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate before date of birth");

        ShowType showType = ShowType.FLEECESHOW;
        LocalDate showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusYears(1);
        LocalDate sheerDate = LocalDate.now().minusYears(2);

        ShowEvent showEvent = new ShowEvent("Show", showDate, LocalDate.now().minusMonths(6), "somewhere", "judge", showType);
        Animal animal = new Animal("Animal", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.WHITE, dateOfBirth, "1", null, "dad", "mom", new ShowEventAnimalDetail(sheerDate, null));

        AgeClassService.ageClass(showEvent, animal);

    }

    @Test
    public void SheerDateMoreThan3YearsAgo () {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate more than 3 years ago");

        ShowType showType = ShowType.FLEECESHOW;
        LocalDate showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusYears(6);
        LocalDate sheerDate = LocalDate.now().minusYears(3);

        ShowEvent showEvent = new ShowEvent("Show", showDate, LocalDate.now().minusMonths(6), "somewhere", "judge", showType);
        Animal animal = new Animal("Animal", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.WHITE, dateOfBirth, "1", null, "dad", "mom", new ShowEventAnimalDetail(sheerDate, null));

        AgeClassService.ageClass(showEvent, animal);

    }

    @Test
    public void SheerDateMustBefilledIfDoBMoreThan3YearsAgo () {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate must be filled if date of birth is more than 3 years ago");

        ShowType showType = ShowType.FLEECESHOW;
        LocalDate showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusYears(3);
        LocalDate sheerDate = null;

        ShowEvent showEvent = new ShowEvent("Show", showDate, LocalDate.now().minusMonths(6), "somewhere", "judge", showType);
        Animal animal = new Animal("Animal", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.WHITE, dateOfBirth, "1", null, "dad", "mom", new ShowEventAnimalDetail(sheerDate, null));

        AgeClassService.ageClass(showEvent, animal);

    }

    @Test
    public void SheerDateNotEmptyForFleeceShow () {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate can not be empty for a fleeceshow");

        ShowType showType = ShowType.FLEECESHOW;
        LocalDate showDate = LocalDate.now();
        dateOfBirth = LocalDate.now().minusYears(1);
        LocalDate sheerDate = null;
        ;

        ShowEvent showEvent = new ShowEvent("Show", showDate, LocalDate.now().minusMonths(6), "somewhere", "judge", showType);
        Animal animal = new Animal("Animal", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.WHITE, dateOfBirth, "1", null, "dad", "mom", new ShowEventAnimalDetail(sheerDate, null));

        AgeClassService.ageClass(showEvent, animal);
    }
}

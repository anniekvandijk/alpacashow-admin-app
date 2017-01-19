package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class ShowClassServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noInstanceTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        exception.expect(InstantiationException.class);
        exception.expectMessage("Instances of this type are forbidden!");

        Constructor<ShowClassService> constructor = ShowClassService.class.getDeclaredConstructor();
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
    public void huacayaJuniorMaleWhiteClassCode() {

        BreedClass breed    = BreedClass.HUACAYA;
        AgeClass ageClass   = AgeClass.JUNIOR;
        SexClass sex        = SexClass.MALE;
        ColorClass color    = ColorClass.WHITE;
        int showClassCode   = 110;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriIntermediateFemaleBeigeClassCode() {

        BreedClass breed    = BreedClass.SURI;
        AgeClass ageClass   = AgeClass.INTERMEDIATE;
        SexClass sex        = SexClass.FEMALE;
        ColorClass color    = ColorClass.BEIGE;
        int showClassCode   = 226;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void HUACAYA_FLEECESeniorMaleBrownClassCode() {

        BreedClass breed    = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass   = AgeClass.SENIOR;
        SexClass sex        = SexClass.MALE;
        ColorClass color    = ColorClass.BROWN;
        int showClassCode   = 372;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void SURI_FLEECEAdultFemaleFawnClassCode() {

        BreedClass breed    = BreedClass.SURI_FLEECE;
        AgeClass ageClass   = AgeClass.ADULT;
        SexClass sex        = SexClass.FEMALE;
        ColorClass color    = ColorClass.FAWN;
        int showClassCode   = 441;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaMatureMaleGreyClassCode() {

        BreedClass breed    = BreedClass.HUACAYA;
        AgeClass ageClass   = AgeClass.MATURE;
        SexClass sex        = SexClass.MALE;
        ColorClass color    = ColorClass.GREY;
        int showClassCode   = 193;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriMatureMaleBlackClassCode() {

        BreedClass breed    = BreedClass.SURI;
        AgeClass ageClass   = AgeClass.MATURE;
        SexClass sex        = SexClass.MALE;
        ColorClass color    = ColorClass.BLACK;
        int showClassCode   = 294;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void HUACAYA_FLEECESeniorFemaleFancyClassCode() {

        BreedClass breed    = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass   = AgeClass.SENIOR;
        SexClass sex        = SexClass.FEMALE;
        ColorClass color    = ColorClass.FANCY;
        int showClassCode   = 365;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaJuniorMaleWhiteClassNameWithSex() {

        BreedClass breed = BreedClass.HUACAYA;
        AgeClass ageClass = AgeClass.JUNIOR;
        SexClass sex = SexClass.MALE;
        ColorClass color = ColorClass.WHITE;
        assertEquals("Huacaya Junior White Male", ShowClassService.getShowClassNameWithSex(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaJuniorMaleWhiteClassNameWithSexFleece() {

        BreedClass breed = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass = AgeClass.JUNIOR;
        SexClass sex = SexClass.MALE;
        ColorClass color = ColorClass.WHITE;
        assertEquals("Huacaya Junior White Male Fleece", ShowClassService.getShowClassNameWithSex(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaJuniorMaleWhiteClassNameWithoutSex() {

        BreedClass breed = BreedClass.SURI;
        AgeClass ageClass = AgeClass.JUNIOR;
        SexClass sex = SexClass.MALE;
        ColorClass color = ColorClass.WHITE;
        assertEquals("Suri Junior White", ShowClassService.getShowClassNameWithoutSex(breed, ageClass, color));
    }

    @Test
    public void huacayaJuniorMaleWhiteClassNameWithoutSexFleece() {

        BreedClass breed = BreedClass.SURI_FLEECE;
        AgeClass ageClass = AgeClass.JUNIOR;
        SexClass sex = SexClass.MALE;
        ColorClass color = ColorClass.WHITE;
        assertEquals("Suri Junior White Fleece", ShowClassService.getShowClassNameWithoutSex(breed, ageClass, color));
    }
}

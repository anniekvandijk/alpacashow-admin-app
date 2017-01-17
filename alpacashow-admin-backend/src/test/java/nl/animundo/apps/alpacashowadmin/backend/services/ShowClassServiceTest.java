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
    public void huacayaFleeceSeniorMaleBrownClassCode() {

        BreedClass breed    = BreedClass.HUACAYAFLEECE;
        AgeClass ageClass   = AgeClass.SENIOR;
        SexClass sex        = SexClass.MALE;
        ColorClass color    = ColorClass.BROWN;
        int showClassCode   = 372;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriFleeceAdultFemaleFawnClassCode() {

        BreedClass breed    = BreedClass.SURIFLEECE;
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
    public void huacayaFleeceSeniorFemaleFancyClassCode() {

        BreedClass breed    = BreedClass.HUACAYAFLEECE;
        AgeClass ageClass   = AgeClass.SENIOR;
        SexClass sex        = SexClass.FEMALE;
        ColorClass color    = ColorClass.FANCY;
        int showClassCode   = 365;

        assertEquals(showClassCode, ShowClassService.getShowClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaJuniorMaleWhiteClassName() {

        BreedClass breed = BreedClass.HUACAYA;
        AgeClass ageClass = AgeClass.JUNIOR;
        SexClass sex = SexClass.MALE;
        ColorClass color = ColorClass.WHITE;
        assertEquals("Huacaya Junior Male White", ShowClassService.getShowClassName(breed, ageClass, sex, color));
    }
}

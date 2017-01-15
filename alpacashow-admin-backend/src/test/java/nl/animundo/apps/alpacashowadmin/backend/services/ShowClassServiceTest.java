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

        int breedCode = BreedClass.HUACAYA.getBreedCode();
        int ageSexCode = AgeSexClass.JUNIOR_MALE.getAgeSexCode();
        int colorCode = ColorClass.WHITE.getColorCode();
        assertEquals(110, ShowClassService.getShowClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void huacayaJuniorMaleWhiteClassCode2() {

        SexClass sex = SexClass.MALE;
        BreedClass breed = BreedClass.HUACAYA;
        ColorClass color = ColorClass.WHITE;
        LocalDate showDate = LocalDate.of(2017, 05, 01);
        LocalDate dateOfBirth = LocalDate.of(2016, 06, 04);
        assertEquals(110, ShowClassService.getShowClassCode(breed, sex, color, showDate, dateOfBirth));
    }

    @Test
    public void huacayaJuniorMaleWhiteClassName() {

        BreedClass breed = BreedClass.HUACAYA;
        AgeClass ageClass = AgeClass.JUNIOR;
        SexClass sex = SexClass.MALE;
        ColorClass color = ColorClass.WHITE;
        assertEquals("Huacaya Junior Male White", ShowClassService.getShowClassName(breed, ageClass, sex, color));
    }

    @Test
    public void suriIntermediateFemaleBeigeClassCode() {

        int breedCode = BreedClass.SURI.getBreedCode();
        int ageSexCode = AgeSexClass.INTERMEDIATE_FEMALE.getAgeSexCode();
        int colorCode = ColorClass.BEIGE.getColorCode();
        assertEquals(226, ShowClassService.getShowClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void huacayaFleeceSeniorMaleBrownClassCode() {

        int breedCode = BreedClass.HUACAYAFLEECE.getBreedCode();
        int ageSexCode = AgeSexClass.SENIOR_MALE.getAgeSexCode();
        int colorCode = ColorClass.BROWN.getColorCode();
        assertEquals(372, ShowClassService.getShowClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void suriFleeceAdultFemaleFawnClassCode() {

        int breedCode = BreedClass.SURIFLEECE.getBreedCode();
        int ageSexCode = AgeSexClass.ADULT_FEMALE.getAgeSexCode();
        int colorCode = ColorClass.FAWN.getColorCode();
        assertEquals(441, ShowClassService.getShowClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void huacayaMatureMaleGreyClassCode() {

        int breedCode = BreedClass.HUACAYA.getBreedCode();
        int ageSexCode = AgeSexClass.MATURE_MALE.getAgeSexCode();
        int colorCode = ColorClass.GREY.getColorCode();
        assertEquals(193, ShowClassService.getShowClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void suriMatureMaleBlackClassCode() {

        int breedCode = BreedClass.SURI.getBreedCode();
        int ageSexCode = AgeSexClass.MATURE_MALE.getAgeSexCode();
        int colorCode = ColorClass.BLACK.getColorCode();
        assertEquals(294, ShowClassService.getShowClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void huacayaFleeceSeniorFemaleFancyClassCode() {

        int breedCode = BreedClass.HUACAYAFLEECE.getBreedCode();
        int ageSexCode = AgeSexClass.SENIOR_FEMALE.getAgeSexCode();
        int colorCode = ColorClass.FANCY.getColorCode();
        assertEquals(365, ShowClassService.getShowClassCode(breedCode, ageSexCode, colorCode));
    }
}

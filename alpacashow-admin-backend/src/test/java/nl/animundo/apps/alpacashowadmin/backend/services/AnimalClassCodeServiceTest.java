package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.AgeSexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noInstanceTest() {

//        reflection?
//        exception.expect(InstantiationException.class);
//        exception.expectMessage("Instances of this type are forbidden!");
    }

    @Test
    public void huacayaJuniorMaleWhiteClassCode() {

        int breedCode = BreedClass.HUACAYA.getBreedCode();
        int ageSexCode = AgeSexClass.JUNIORMALE.getAgeSexCode();
        int colorCode = ColorClass.WHITE.getColorCode();
        assertEquals(110, AnimalClassCodeService.getAnimalClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void suriIntermediateFemaleBeigeClassCode() {

        int breedCode = BreedClass.SURI.getBreedCode();
        int ageSexCode = AgeSexClass.INTERMEDIATEFEMALE.getAgeSexCode();
        int colorCode = ColorClass.BEIGE.getColorCode();
        assertEquals(226, AnimalClassCodeService.getAnimalClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void huacayaFleeceSeniorMaleBrownClassCode() {

        int breedCode = BreedClass.HUACAYAFLEECE.getBreedCode();
        int ageSexCode = AgeSexClass.SENIORMALE.getAgeSexCode();
        int colorCode = ColorClass.BROWN.getColorCode();
        assertEquals(372, AnimalClassCodeService.getAnimalClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void suriFleeceAdultFemaleFawnClassCode() {

        int breedCode = BreedClass.SURIFLEECE.getBreedCode();
        int ageSexCode = AgeSexClass.ADULTFEMALE.getAgeSexCode();
        int colorCode = ColorClass.FAWN.getColorCode();
        assertEquals(441, AnimalClassCodeService.getAnimalClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void huacayaMatureMaleGreyClassCode() {

        int breedCode = BreedClass.HUACAYA.getBreedCode();
        int ageSexCode = AgeSexClass.MATUREMALE.getAgeSexCode();
        int colorCode = ColorClass.GREY.getColorCode();
        assertEquals(193, AnimalClassCodeService.getAnimalClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void suriMatureMaleBlackClassCode() {

        int breedCode = BreedClass.SURI.getBreedCode();
        int ageSexCode = AgeSexClass.MATUREMALE.getAgeSexCode();
        int colorCode = ColorClass.BLACK.getColorCode();
        assertEquals(294, AnimalClassCodeService.getAnimalClassCode(breedCode, ageSexCode, colorCode));
    }

    @Test
    public void huacayaFleeceSeniorFemaleFancyClassCode() {

        int breedCode = BreedClass.HUACAYAFLEECE.getBreedCode();
        int ageSexCode = AgeSexClass.SENIORFEMALE.getAgeSexCode();
        int colorCode = ColorClass.FANCY.getColorCode();
        assertEquals(365, AnimalClassCodeService.getAnimalClassCode(breedCode, ageSexCode, colorCode));
    }
}

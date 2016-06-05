package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceFullClassCodeTest {

    // TODO vraag, foute waarden worden al getest in de diverse andere methoden, moet dat hier weer?

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void forbiddenInstanceOfClass() throws InstantiationException {

        exception.expect(InstantiationException.class);
        exception.expectMessage("Instances of this type are forbidden!");

        AnimalClassCodeService animalClassCodeService = new AnimalClassCodeService();
    }

    @Test
    public void huacayaJuniorMaleWhiteClassCode() {

        Enum breed = Animal.breed.HUACAYA;
        Enum ageClass = AnimalClassCodeService.ageClass.JUNIOR;
        Enum sex = Animal.sex.MALE;
        Enum color = Animal.color.WHITE;
        assertEquals(110, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriIntermediateFemaleBeigeClassCode() {

        Enum breed = Animal.breed.SURI;
        Enum ageClass = AnimalClassCodeService.ageClass.INTERMEDIATE;
        Enum sex = Animal.sex.FEMALE;
        Enum color = Animal.color.BEIGE;
        assertEquals(226, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaFleeceSeniorMaleBrownClassCode() {

        Enum breed = Animal.breed.HUACAYAFLEECE;
        Enum ageClass = AnimalClassCodeService.ageClass.SENIOR;
        Enum sex = Animal.sex.MALE;
        Enum color = Animal.color.BROWN;
        assertEquals(372, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriFleeceAdultFemaleFawnClassCode() {

        Enum breed = Animal.breed.SURIFLEECE;
        Enum ageClass = AnimalClassCodeService.ageClass.ADULT;
        Enum sex = Animal.sex.FEMALE;
        Enum color = Animal.color.FAWN;
        assertEquals(441, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaMatureMaleGreyClassCode() {

        Enum breed = Animal.breed.HUACAYA;
        Enum ageClass = AnimalClassCodeService.ageClass.MATURE;
        Enum sex = Animal.sex.MALE;
        Enum color = Animal.color.GREY;
        assertEquals(193, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriMatureMaleBlackClassCode() {

        Enum breed = Animal.breed.SURI;
        Enum ageClass = AnimalClassCodeService.ageClass.MATURE;
        Enum sex = Animal.sex.MALE;
        Enum color = Animal.color.BLACK;
        assertEquals(294, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaFleeceSeniorFemaleFancyClassCode() {

        Enum breed = Animal.breed.HUACAYAFLEECE;
        Enum ageClass = AnimalClassCodeService.ageClass.SENIOR;
        Enum sex = Animal.sex.FEMALE;
        Enum color = Animal.color.FANCY;
        assertEquals(365, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }
}

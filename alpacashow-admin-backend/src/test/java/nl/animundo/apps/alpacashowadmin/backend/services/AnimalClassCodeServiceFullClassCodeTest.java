package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceFullClassCodeTest {

    // TODO vraag, foute waarden worden al getest in de diverse andere methoden, moet dat hier weer?

    @Test
    public void huacayaJuniorMaleWhiteClassCode() {

        String breed = "Huacaya";
        String ageClass = "Junior";
        String sex = "Male";
        String color = "White";
        assertEquals(110, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriIntermediateFemaleBeigeClassCode() {

        String breed = "Suri";
        String ageClass = "Intermediate";
        String sex = "Female";
        String color = "Beige";
        assertEquals(226, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaFleeceSeniorMaleBrownClassCode() {

        String breed = "Huacaya Fleece";
        String ageClass = "Senior";
        String sex = "Male";
        String color = "Brown";
        assertEquals(372, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriFleeceAdultFemaleFawnClassCode() {

        String breed = "Suri Fleece";
        String ageClass = "Adult";
        String sex = "Female";
        String color = "Fawn";
        assertEquals(441, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaMatureMaleGreyClassCode() {

        String breed = "Huacaya";
        String ageClass = "Mature";
        String sex = "Male";
        String color = "Grey";
        assertEquals(193, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void suriMatureMaleBlackClassCode() {

        String breed = "Suri";
        String ageClass = "Mature";
        String sex = "Male";
        String color = "Black";
        assertEquals(294, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }

    @Test
    public void huacayaFleeceSeniorFemaleFancyClassCode() {

        String breed = "Huacaya Fleece";
        String ageClass = "Senior";
        String sex = "Female";
        String color = "Fancy";
        assertEquals(365, AnimalClassCodeService.getAnimalClassCode(breed, ageClass, sex, color));
    }
}

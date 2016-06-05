package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceAgeSexCodeTest {

//    JUNIOR FEMALE	0
//    JUNIOR MALE	1
//    INTERMEDIATE FEMALE	2
//    INTERMEDIATE MALE	3
//    ADULT FEMALE	4
//    ADULT MALE	5
//    SENIOR FEMALE	6
//    SENIOR MALE	7
//    MATURE FEMALE	8
//    MATURE MALE	9
//    AFST FLEECE	40
//    AFST FEMALE	90
//    AFST MALE	91
//    GELDER	95

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void juniorFemaleCode() {

        Enum sex = Animal.sex.FEMALE;
        Enum ageClass = AnimalClassCodeService.ageClass.JUNIOR;
        assertEquals(0, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void intermediateFemaleCode() {

        Enum sex = Animal.sex.FEMALE;
        Enum ageClass = AnimalClassCodeService.ageClass.INTERMEDIATE;
        assertEquals(2, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void adultFemaleCode() {

        Enum sex = Animal.sex.FEMALE;
        Enum ageClass = AnimalClassCodeService.ageClass.ADULT;
        assertEquals(4, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void seniorFemaleCode() {

        Enum sex = Animal.sex.FEMALE;
        Enum ageClass = AnimalClassCodeService.ageClass.SENIOR;
        assertEquals(6, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void matureFemaleCode() {

        Enum sex = Animal.sex.FEMALE;
        Enum ageClass = AnimalClassCodeService.ageClass.MATURE;
        assertEquals(8, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void juniorMaleCode() {

        Enum sex = Animal.sex.MALE;
        Enum ageClass = AnimalClassCodeService.ageClass.JUNIOR;
        assertEquals(1, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void intermediateMaleCode() {

        Enum sex = Animal.sex.MALE;
        Enum ageClass = AnimalClassCodeService.ageClass.INTERMEDIATE;
        assertEquals(3, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void adultMaleCode() {

        Enum sex = Animal.sex.MALE;
        Enum ageClass = AnimalClassCodeService.ageClass.ADULT;
        assertEquals(5, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void seniorMaleCode() {

        Enum sex = Animal.sex.MALE;
        Enum ageClass = AnimalClassCodeService.ageClass.SENIOR;
        assertEquals(7, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void matureMaleCode() {

        Enum sex = Animal.sex.MALE;
        Enum ageClass = AnimalClassCodeService.ageClass.MATURE;
        assertEquals(9, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }
}

package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Test;

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

    @Test
    public void unknownSex() {
        String sex = "Gelder";
        String ageClass = "Junior";
        assertEquals(-1, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void unknownAgeClass() {
        String sex = "Female";
        String ageClass = "Baby";
        assertEquals(-1, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void unknownSexAndAgeClass() {
        String sex = "Gelder";
        String ageClass = "Baby";
        assertEquals(-1, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void juniorFemaleCode() {

        String sex = "Female";
        String ageClass = "Junior";
        assertEquals(0, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void intermediateFemaleCode() {

        String sex = "Female";
        String ageClass = "Intermediate";
        assertEquals(2, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void adultFemaleCode() {

        String sex = "Female";
        String ageClass = "Adult";
        assertEquals(4, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void seniorFemaleCode() {

        String sex = "Female";
        String ageClass = "Senior";
        assertEquals(6, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void matureFemaleCode() {

        String sex = "Female";
        String ageClass = "Mature";
        assertEquals(8, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void juniorMaleCode() {

        String sex = "Male";
        String ageClass = "Junior";
        assertEquals(1, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void intermediateMaleCode() {

        String sex = "Male";
        String ageClass = "Intermedeiate";
        assertEquals(3, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void adultMaleCode() {

        String sex = "Male";
        String ageClass = "Adult";
        assertEquals(5, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void seniorMaleCode() {

        String sex = "Male";
        String ageClass = "Senior";
        assertEquals(7, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }

    @Test
    public void matureMaleCode() {

        String sex = "Male";
        String ageClass = "Mature";
        assertEquals(9, AnimalClassCodeService.getAgeSexCode(ageClass, sex));
    }
}

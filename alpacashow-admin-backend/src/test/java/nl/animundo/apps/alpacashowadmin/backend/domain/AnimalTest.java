package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public class AnimalTest {

    String name;
    BreedClass breedClass;
    SexClass sexClass;
    ColorClass colorClass;
    LocalDate dateOfBirth;
    String microchip;
    String registration;
    String sire;
    String dam;

    /* TODO
    Check unique:
    - Name
    - MicroChip
    - Registration
    Required fields:
    All except registration
     */

    @Test
    public void newAnimal1() {

        name            = "Alpacaname";
        breedClass      = BreedClass.HUACAYA;
        sexClass        = SexClass.FEMALE;
        colorClass      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        Animal animal = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);

        assertEquals("Alpacaname", animal.getName());
        assertEquals(BreedClass.HUACAYA, animal.getBreedClass());
        assertEquals(SexClass.FEMALE, animal.getSexClass());
        assertEquals(ColorClass.WHITE, animal.getColorClass());
        assertEquals(LocalDate.now().minusMonths(6), animal.getDateOfBirth());
        assertEquals("982000123169930", animal.getMicrochip());
        assertEquals("BAF12345", animal.getRegistration());
        assertEquals("Alpaca father", animal.getSire());
        assertEquals("Alpaca mother", animal.getDam());

    }

    @Test
    public void newAnimal2() {

        name            = "Alpacaname2";
        breedClass      = BreedClass.SURI;
        sexClass        = SexClass.MALE;
        colorClass      = ColorClass.FAWN;
        dateOfBirth     = LocalDate.now().minusMonths(12);
        microchip       = "982000123169931";
        registration    = "BAF12346";
        sire            = "Alpaca father2";
        dam             = "Alpaca mother2";

        Animal animal = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);

        assertEquals("Alpacaname2", animal.getName());
        assertEquals(BreedClass.SURI, animal.getBreedClass());
        assertEquals(SexClass.MALE, animal.getSexClass());
        assertEquals(ColorClass.FAWN, animal.getColorClass());
        assertEquals(LocalDate.now().minusMonths(12), animal.getDateOfBirth());
        assertEquals("982000123169931", animal.getMicrochip());
        assertEquals("BAF12346", animal.getRegistration());
        assertEquals("Alpaca father2", animal.getSire());
        assertEquals("Alpaca mother2", animal.getDam());

    }


}

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

    @Test
    public void newAnimal() {

        name            = "Alpacaname";
        breedClass      = BreedClass.HUACAYA;
        sexClass        = SexClass.FEMALE;
        colorClass      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.of(2016,5,1);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        Animal animal = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);

        assertEquals("Alpacaname", animal.getName());
        assertEquals(BreedClass.HUACAYA, animal.getBreedClass());
        assertEquals(SexClass.FEMALE, animal.getSexClass());
        assertEquals(ColorClass.WHITE, animal.getColorClass());
        assertEquals(LocalDate.of(2016,5,1), animal.getDateOfBirth());
        assertEquals("982000123169930", animal.getMicrochip());
        assertEquals("BAF12345", animal.getRegistration());
        assertEquals("Alpaca father", animal.getSire());
        assertEquals("Alpaca mother", animal.getDam());

    }


}

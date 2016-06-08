package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Test;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public class AnimalTest {

    String name;
    String breed;
    String sex;
    String color;
    String dateOfBirth;


        /*
     * Velden:
     * Naam
     * Type (breed)
     * Geslacht
     * Kleur
     * Geboortedatum
     * Microship
     * Registratienummer
     * Naam vader
     * Naam moeder
     */

    @Test
    public void newAnimal() {

        name = "Alpacaname";
        breed = "Huacaya";
        sex = "Female";
        color = "White";
        dateOfBirth = "01-05-2016";


    }


}

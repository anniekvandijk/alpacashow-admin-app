package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassServiceBreedCodeTest {

    // Huacaya = 1
    // Suri = 2
    // Huacaya fleece = 3
    // Suri Fleece = 4

    @Test
    public void noBreed() {

        // TODO How to create errormessage to return?

        String breed = "";
        assertEquals(-1, AnimalClassService.getBreedCode(breed));
    }

    @Test
    public void unknownBreed() {

        // TODO How to create errormessage to return?

        String breed = "Ezel";
        assertEquals(-1, AnimalClassService.getBreedCode(breed));
    }

    @Test
    public void huacayaBreedCode() {

        String breed = "Huacaya";
        assertEquals(1, AnimalClassService.getBreedCode(breed));
    }

    @Test
    public void suriBreedCode() {

        String breed = "Suri";
        assertEquals(2, AnimalClassService.getBreedCode(breed));
    }

    @Test
    public void huacayaFleeceBreedCode() {

        String breed = "Huacaya Fleece";
        assertEquals(3, AnimalClassService.getBreedCode(breed));
    }

    @Test
    public void suriFleeceBreedCode() {

        String breed = "Suri Fleece";
        assertEquals(4, AnimalClassService.getBreedCode(breed));
    }
}

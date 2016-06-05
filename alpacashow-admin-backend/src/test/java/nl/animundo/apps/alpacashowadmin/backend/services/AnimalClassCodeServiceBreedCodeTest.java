package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceBreedCodeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noBreed() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Soort onbekend");

        String breed = "";
        AnimalClassCodeService.getBreedCode(breed);
    }

    @Test
    public void unknownBreed() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Soort onbekend");

        String breed = "Ezel";
        AnimalClassCodeService.getBreedCode(breed);
    }

    @Test
    public void huacayaBreedCode() {

        String breed = "Huacaya";
        assertEquals(1, AnimalClassCodeService.getBreedCode(breed));
    }

    @Test
    public void suriBreedCode() {

        String breed = "Suri";
        assertEquals(2, AnimalClassCodeService.getBreedCode(breed));
    }

    @Test
    public void huacayaFleeceBreedCode() {

        String breed = "Huacaya Fleece";
        assertEquals(3, AnimalClassCodeService.getBreedCode(breed));
    }

    @Test
    public void suriFleeceBreedCode() {

        String breed = "Suri Fleece";
        assertEquals(4, AnimalClassCodeService.getBreedCode(breed));
    }
}

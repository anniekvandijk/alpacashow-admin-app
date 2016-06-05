package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
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
    public void huacayaBreedCode() {

        Enum breed = Animal.breed.HUACAYA;
        assertEquals(1, AnimalClassCodeService.getBreedCode(breed));
    }

    @Test
    public void suriBreedCode() {

        Enum breed = Animal.breed.SURI;
        assertEquals(2, AnimalClassCodeService.getBreedCode(breed));
    }

    @Test
    public void huacayaFleeceBreedCode() {

        Enum breed = Animal.breed.HUACAYAFLEECE;
        assertEquals(3, AnimalClassCodeService.getBreedCode(breed));
    }

    @Test
    public void suriFleeceBreedCode() {

        Enum breed = Animal.breed.SURIFLEECE;
        assertEquals(4, AnimalClassCodeService.getBreedCode(breed));
    }
}

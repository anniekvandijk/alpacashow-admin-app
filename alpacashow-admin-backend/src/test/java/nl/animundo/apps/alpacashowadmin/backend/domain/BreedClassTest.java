package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class BreedClassTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void breedHuacaya() {

        assertEquals("Huacaya", BreedClass.HUACAYA.getBreed());
    }

    @Test
    public void breedSuri() {

        assertEquals("Suri", BreedClass.SURI.getBreed());
    }

    @Test
    public void breedHuacayafleece() {

        assertEquals("Huacaya fleece", BreedClass.HUACAYAFLEECE.getBreed());
    }

    @Test
    public void breedSurifleece() {

        assertEquals("Suri fleece", BreedClass.SURIFLEECE.getBreed());
    }


    @Test
    public void huacayaBreedCode() {

        assertEquals(1, BreedClass.HUACAYA.getBreedCode());
    }

    @Test
    public void suriBreedCode() {

        assertEquals(2, BreedClass.SURI.getBreedCode());
    }

    @Test
    public void huacayaFleeceBreedCode() {

        assertEquals(3, BreedClass.HUACAYAFLEECE.getBreedCode());
    }

    @Test
    public void suriFleeceBreedCode() {

        assertEquals(4, BreedClass.SURIFLEECE.getBreedCode());
    }
}

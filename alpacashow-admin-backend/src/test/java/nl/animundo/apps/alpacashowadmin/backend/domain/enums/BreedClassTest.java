package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class BreedClassTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void huacayaBreedCode() {

        assertEquals(1, BreedClass.HUACAYA.getBreedCode());
    }

    @Test
    public void suriBreedCode() {

        assertEquals(2, BreedClass.SURI.getBreedCode());
    }

    @Test
    public void HUACAYA_FLEECEBreedCode() {

        assertEquals(3, BreedClass.HUACAYA_FLEECE.getBreedCode());
    }

    @Test
    public void SURI_FLEECEBreedCode() {

        assertEquals(4, BreedClass.SURI_FLEECE.getBreedCode());
    }
}

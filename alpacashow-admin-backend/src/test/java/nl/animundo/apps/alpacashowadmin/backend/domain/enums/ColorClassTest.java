package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ColorClassTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whiteColorCode() {

        assertEquals(0, ColorClass.WHITE.getColorCode());
    }

    @Test
    public void fawnColorCode() {

        assertEquals(1, ColorClass.FAWN.getColorCode());
    }

    @Test
    public void brownColorCode() {

        assertEquals(2, ColorClass.BROWN.getColorCode());
    }

    @Test
    public void greyColorCode() {

        assertEquals(3, ColorClass.GREY.getColorCode());
    }

    @Test
    public void blackColorCode() {

        assertEquals(4, ColorClass.BLACK.getColorCode());
    }

    @Test
    public void fancyColorCode() {

        assertEquals(5, ColorClass.FANCY.getColorCode());
    }

    @Test
    public void beigeColorCode() {

        assertEquals(6, ColorClass.BEIGE.getColorCode());
    }
}


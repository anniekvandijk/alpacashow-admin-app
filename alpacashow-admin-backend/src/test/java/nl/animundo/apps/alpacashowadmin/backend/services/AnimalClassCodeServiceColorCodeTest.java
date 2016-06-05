package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassCodeServiceColorCodeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whiteColorCode() {

        Enum color = Animal.color.WHITE;
        assertEquals(0, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void fawnColorCode() {

        Enum color = Animal.color.FAWN;
        assertEquals(1, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void brownColorCode() {

        Enum color = Animal.color.BROWN;
        assertEquals(2, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void greyColorCode() {

        Enum color = Animal.color.GREY;
        assertEquals(3, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void blackColorCode() {

        Enum color = Animal.color.BLACK;
        assertEquals(4, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void fancyColorCode() {

        Enum color = Animal.color.FANCY;
        assertEquals(5, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void beigeColorCode() {

        Enum color = Animal.color.BEIGE;
        assertEquals(6, AnimalClassCodeService.getColorCode(color));
    }
}

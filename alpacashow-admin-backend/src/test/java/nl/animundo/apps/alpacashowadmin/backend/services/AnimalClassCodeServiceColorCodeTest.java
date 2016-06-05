package nl.animundo.apps.alpacashowadmin.backend.services;

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
    public void noColor() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Kleur onbekend");

        String color = "";
        AnimalClassCodeService.getColorCode(color);
    }

    @Test
    public void unknownColor() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Kleur onbekend");

        String color = "Blue";
        AnimalClassCodeService.getColorCode(color);
    }

    @Test
    public void whiteColorCode() {

        String color = "White";
        assertEquals(0, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void fawnColorCode() {

        String color = "Fawn";
        assertEquals(1, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void brownColorCode() {

        String color = "Brown";
        assertEquals(2, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void greyColorCode() {

        String color = "Grey";
        assertEquals(3, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void blackColorCode() {

        String color = "Black";
        assertEquals(4, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void fancyColorCode() {

        String color = "Fancy";
        assertEquals(5, AnimalClassCodeService.getColorCode(color));
    }

    @Test
    public void beigeColorCode() {

        String color = "Beige";
        assertEquals(6, AnimalClassCodeService.getColorCode(color));
    }
}

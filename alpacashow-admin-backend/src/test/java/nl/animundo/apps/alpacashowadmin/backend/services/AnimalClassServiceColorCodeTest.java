package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 3-6-2016.
 */
public class AnimalClassServiceColorCodeTest {

    @Test
    public void noColor() {

        // TODO How to create errormessage to return?

        String color = "";
        assertEquals(-1, AnimalClassService.getColorCode(color));
    }

    @Test
    public void unknownColor() {

        // TODO How to create errormessage to return?

        String color = "Blue";
        assertEquals(-1, AnimalClassService.getColorCode(color));
    }

    @Test
    public void whiteColorCode() {

        String color = "White";
        assertEquals(0, AnimalClassService.getColorCode(color));
    }

    @Test
    public void fawnColorCode() {

        String color = "Fawn";
        assertEquals(1, AnimalClassService.getColorCode(color));
    }

    @Test
    public void brownColorCode() {

        String color = "Brown";
        assertEquals(2, AnimalClassService.getColorCode(color));
    }

    @Test
    public void greyColorCode() {

        String color = "Grey";
        assertEquals(3, AnimalClassService.getColorCode(color));
    }

    @Test
    public void blackColorCode() {

        String color = "Black";
        assertEquals(4, AnimalClassService.getColorCode(color));
    }

    @Test
    public void fancyColorCode() {

        String color = "Fancy";
        assertEquals(5, AnimalClassService.getColorCode(color));
    }

    @Test
    public void beigeColorCode() {

        String color = "Beige";
        assertEquals(6, AnimalClassService.getColorCode(color));
    }
}

package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 12-6-2016.
 */
public class ShowTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newShow() {

        Show show = new Show(ShowType.HALTERSHOW);

        assertEquals(ShowType.HALTERSHOW, show.getShowType());
    }

    @Test
    public void newShow2() {

        Show show = new Show(ShowType.valueOf("HALTERSHOW"));

        assertEquals(ShowType.HALTERSHOW, show.getShowType());
    }

    @Test
    public void showNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Show can not be empty");

        new Show(null);
    }

}

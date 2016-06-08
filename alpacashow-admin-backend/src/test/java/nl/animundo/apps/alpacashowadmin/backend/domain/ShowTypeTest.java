package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public class ShowTypeTest {

    @Test
    public void showTypeHaltershow() {

        assertEquals("Haltershow", ShowType.HALTERSHOW.getShowType());
    }

    @Test
    public void showTypeFleeceshow() {

        assertEquals("Fleeceshow", ShowType.FLEECESHOW.getShowType());
    }

    @Test
    public void showTypeFemaleProgenyshow() {

        assertEquals("Female progeny show", ShowType.FEMALEPROGENYSHOW.getShowType());
    }

    @Test
    public void showTypeMaleProgenyshow() {

        assertEquals("Male progeny show", ShowType.MALEPROGENYSHOW.getShowType());
    }
}

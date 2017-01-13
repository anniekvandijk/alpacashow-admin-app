package nl.animundo.apps.alpacashowadmin.backend.domain.enums;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AgeClassTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void junior() {

        assertEquals(6, AgeClass.JUNIOR.getMonthMin());
        assertEquals(11, AgeClass.JUNIOR.getMonthMax());
    }

    @Test
    public void intermediate() {

        assertEquals(12, AgeClass.INTERMEDIATE.getMonthMin());
        assertEquals(23, AgeClass.INTERMEDIATE.getMonthMax());
    }

    @Test
    public void adult() {

        assertEquals(24, AgeClass.ADULT.getMonthMin());
        assertEquals(47, AgeClass.ADULT.getMonthMax());
    }

    @Test
    public void senior() {

        assertEquals(48, AgeClass.SENIOR.getMonthMin());
        assertEquals(71, AgeClass.SENIOR.getMonthMax());
    }

    @Test
    public void mature() {

        assertEquals(72, AgeClass.MATURE.getMonthMin());
        assertEquals(600, AgeClass.MATURE.getMonthMax());
    }
}

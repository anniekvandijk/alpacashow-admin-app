package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AnimalFleeceShowFleeceWeightTest {

    private String showEventKey;
    private int startNumber;
    private float fleeceWeight;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newFleeceShowNumber() {

        showEventKey = "2030-05-01_FLEECESHOW";
        startNumber = 1;

        AnimalFleeceShowFleeceWeight animalFleeceShowFleeceWeight = new AnimalFleeceShowFleeceWeight(showEventKey, startNumber, fleeceWeight);

        assertEquals(showEventKey, animalFleeceShowFleeceWeight.getShowEventKey());
        assertEquals(startNumber, animalFleeceShowFleeceWeight.getStartNumber());
        assertEquals(0.0f, animalFleeceShowFleeceWeight.getFleeceWeight(), 0.05);
    }

    @Test
    public void newFleeceShowNumberWithFleece() {

        showEventKey = "2030-05-01_FLEECESHOW";
        startNumber = 1;
        fleeceWeight = 1.567f;

        AnimalFleeceShowFleeceWeight animalFleeceShowFleeceWeight = new AnimalFleeceShowFleeceWeight(showEventKey, startNumber, fleeceWeight);

        assertEquals(showEventKey, animalFleeceShowFleeceWeight.getShowEventKey());
        assertEquals(startNumber, animalFleeceShowFleeceWeight.getStartNumber());
        assertEquals(fleeceWeight, animalFleeceShowFleeceWeight.getFleeceWeight(), 0.05);
    }
}

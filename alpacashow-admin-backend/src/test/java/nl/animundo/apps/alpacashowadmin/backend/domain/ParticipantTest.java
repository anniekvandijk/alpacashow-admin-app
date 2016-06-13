package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


/**
 * Created by Anniek van Dijk on 10-6-2016.
 */
public class ParticipantTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newParticipantWithTrim() {

        String name = " New Participant";

        Participant participant = new Participant(name);

        assertEquals("New Participant", participant.getName());
    }

    @Test
    public void newParticipantWithAnimals() {

        String name = " New Participant";
        Set<Animal> animals = new HashSet<>();
        animals.add(new Animal("Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.now().minusYears(1), "123456789", null, "Vader", "Moeder"));
        animals.add(new Animal("Alpaca2", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.now().minusYears(2), "987654321", "BAF12345", "Vader2", "Moeder2"));

        Participant participant = new Participant(name, animals);

        assertEquals(animals, participant.getAnimals());
    }


    @Test
    public void participantNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field participant can not be empty");

        String name = null;

        new Participant(name);
    }
}

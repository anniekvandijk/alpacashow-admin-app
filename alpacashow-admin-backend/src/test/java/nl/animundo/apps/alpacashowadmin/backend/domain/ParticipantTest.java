package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class ParticipantTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newParticipantWithTrim() {

        String name = " New Participant";
        String farmName = "farm";
        String email = " farm@farm.nl ";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands   ";

        Participant participant = new Participant(name, farmName, email, telephone, address, zipCode, city, country);

        assertEquals("New Participant", participant.getName());
        assertEquals("farm", participant.getFarmName());
        assertEquals("farm@farm.nl", participant.getEmail());
        assertEquals("06-12345678", participant.getTelephone());
        assertEquals("some address", participant.getAddress());
        assertEquals("1234 AA", participant.getZipCode());
        assertEquals("some City", participant.getCity());
        assertEquals("Netherlands", participant.getCountry());
    }

    @Test
    public void newParticipantWithAnimals() {

        String name = "New Participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Set<Animal> animals = new HashSet<>();
        animals.add(new Animal("Alpaca1", BreedClass.HUACAYA, SexClass.FEMALE, ColorClass.BLACK, LocalDate.now().minusYears(1), "123456789", null, "Vader", "Moeder"));
        animals.add(new Animal("Alpaca2", BreedClass.SURI, SexClass.MALE, ColorClass.FANCY, LocalDate.now().minusYears(2), "987654321", "BAF12345", "Vader2", "Moeder2"));

        Participant participant = new Participant(name, farmName, email, telephone, address, zipCode, city, country, animals);

        assertEquals(animals, participant.getAnimals());
    }

    @Test
    public void participantNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field participant can not be empty");

        String name = "  ";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        new Participant(name, farmName, email, telephone, address, zipCode, city, country);
    }

    @Test
    public void participantNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field participant can not be empty");

        String name = null;
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        new Participant(name, farmName, email, telephone, address, zipCode, city, country);
    }
}

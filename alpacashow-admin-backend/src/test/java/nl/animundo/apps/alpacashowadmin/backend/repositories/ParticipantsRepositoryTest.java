package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ParticipantsRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ParticipantsRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getParticipant() {

        String name = "Test participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant = new Participant(name, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add(participant);

        String key = "Test participant";
        assertEquals("Test participant", participantRepository.getParticipantByKeySet(key).getName());

    }

    @Test
    public void AddParticipantWithSameKey() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Participant already exists");

        String name = "Test participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant1 = new Participant(name, farmName, email, telephone, address, zipCode, city, country);
        Participant participant2 = new Participant(name, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add(participant1);
        participantRepository.add(participant2);
    }

    @Test
    public void getNotKnownParticipant() {

        exception.expect(NullPointerException.class);

        String name = "Test participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant = new Participant(name, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add(participant);

        String key = "Andere participant";

        participantRepository.getParticipantByKeySet(key).getName();
    }

    @Test
    public void getAllParticpants() {

        String name1 = "Test participant";
        String name2 = "Andere participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant1 = new Participant(name1, farmName, email, telephone, address, zipCode, city, country);
        Participant participant2 = new Participant(name2, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add(participant1);
        participantRepository.add(participant2);

        assertEquals(2, participantRepository.getAllParticipants().size());

    }
}



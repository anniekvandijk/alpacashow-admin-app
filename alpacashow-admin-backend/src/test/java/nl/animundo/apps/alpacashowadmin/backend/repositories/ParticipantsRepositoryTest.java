package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParticipantsRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ParticipantsRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addParticipant() {

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
        assertEquals(key, participantRepository.getParticipantByKeySet(key).getName());

    }

    @Test
    public void AddParticipantWithSameKey() {

        String name = "Test participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address1 = "some address";
        String address2 = "some other address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant1 = new Participant(name, farmName, email, telephone, address1, zipCode, city, country);
        Participant participant2 = new Participant(name, farmName, email, telephone, address2, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add(participant1);
        participantRepository.add(participant2);

        String key = "Test participant";
        assertEquals("some other address", participantRepository.getParticipantByKeySet(key).getAddress());
    }

    @Test
    public void deleteParticipant() {

        String name = "Test participant to delete";
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

        assertEquals(1, participantRepository.getAllParticipants().size());
        String key = "Test participant to delete";
        assertEquals(key, participantRepository.getParticipantByKeySet(key).getName());

        participantRepository.delete(key);

        assertEquals(0, participantRepository.getAllParticipants().size());
    }

    @Test
    public void deleteParticipantWithNotKnownKey() {

        exception.expect(NullPointerException.class);

        String name = "Test participant to delete";
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

        assertEquals(1, participantRepository.getAllParticipants().size());

        String key = "Not known participant";
        participantRepository.delete(key);

        assertEquals(1, participantRepository.getAllParticipants().size());
        assertEquals(null, participantRepository.delete(key).toString());

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
    public void getAllParticipantsByKeySet() {

        String name1 = "Test participant";
        String name2 = "Test participant nummer 2";
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

        assertEquals(2, participantRepository.getAllParticipantsByKeySet().size());
        assertTrue(participantRepository.getAllParticipantsByKeySet().contains("Test participant"));
        assertTrue(participantRepository.getAllParticipantsByKeySet().contains("Test participant nummer 2"));
    }


}



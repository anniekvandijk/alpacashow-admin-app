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

        String id = "582fc7a6-aa85-41cf-96b8-3981f5df0093";
        String name = "Test participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant = new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add(participant);

        assertEquals(name, participantRepository.getParticipantById(id).getName());

    }

    @Test
    public void deleteParticipant() {

        String id = "582fc7a6-aa85-41cf-96b8-3981f5df0093";
        String name = "Test participant to delete";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant = new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();
        participantRepository.add(participant);

        assertEquals(1, participantRepository.getAllParticipants().size());

        participantRepository.delete(id);

        assertEquals(0, participantRepository.getAllParticipants().size());
    }

    @Test
    public void deleteParticipantWithNotKnownId() {

        exception.expect(NullPointerException.class);

        String id = "582fc7a6-aa85-41cf-96b8-3981f5df0093";
        String name = "Test participant to delete";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant = new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();
        participantRepository.add(participant);

        assertEquals(1, participantRepository.getAllParticipants().size());

        String id2 = "12345";
        participantRepository.delete(id2);

        assertEquals(1, participantRepository.getAllParticipants().size());
        assertEquals(null, participantRepository.delete(id2).toString());

    }

    @Test
    public void getNotKnownParticipant() {

        exception.expect(NullPointerException.class);

        String id = "582fc7a6-aa85-41cf-96b8-3981f5df0093";
        String name = "Test participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant = new Participant(id, name, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add(participant);

        String id2 = "12345";

        participantRepository.getParticipantById(id2).getName();
    }

    @Test
    public void getAllParticipantsByKeySet() {

        String id1 = "582fc7a6-aa85-41cf-96b8-3981f5df0093";
        String id2 = "582fc7a6-aa85-41cf-96b8-3981f5df0094";
        String name1 = "Test participant";
        String name2 = "Test participant nummer 2";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        Participant participant1 = new Participant(id1, name1, farmName, email, telephone, address, zipCode, city, country);
        Participant participant2 = new Participant(id2, name2, farmName, email, telephone, address, zipCode, city, country);
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add(participant1);
        participantRepository.add(participant2);

        assertEquals(2, participantRepository.getAllParticipantsById().size());
        assertTrue(participantRepository.getAllParticipantsById().contains("582fc7a6-aa85-41cf-96b8-3981f5df0093"));
        assertTrue(participantRepository.getAllParticipantsById().contains("582fc7a6-aa85-41cf-96b8-3981f5df0094"));
    }


}



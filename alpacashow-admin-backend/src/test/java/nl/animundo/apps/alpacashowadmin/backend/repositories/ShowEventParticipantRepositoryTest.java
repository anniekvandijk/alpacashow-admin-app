package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipant;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowEventParticipantRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ShowEventParticipantRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addShowEventParticipant() throws IOException {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";

        ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);
        ShowEventParticipantRepository showEventParticipantRepository = new ShowEventParticipantRepository();

        assertEquals(0, showEventParticipantRepository.getAllShowEventParticipants().size());

        showEventParticipantRepository.add(showEventParticipant);

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1";

        assertEquals(1, showEventParticipantRepository.getAllShowEventParticipants().size());
        assertEquals(participantKey, showEventParticipantRepository.getShowEventParticipantByKeySet(key).getParticipantKey());
    }

    @Test
    public void deleteShowEventParticipant() throws IOException {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";

        ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);

        ShowEventParticipantRepository showEventParticipantRepository = new ShowEventParticipantRepository();

        showEventParticipantRepository.add(showEventParticipant);

        assertEquals(1, showEventParticipantRepository.getAllShowEventParticipants().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1";

        showEventParticipantRepository.delete(key);

        assertEquals(0, showEventParticipantRepository.getAllShowEventParticipants().size());
    }

    @Test
    public void deleteShowEventParticipantWithNotKnownKey() throws IOException {

        exception.expect(NullPointerException.class);

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";

        ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);
        ShowEventParticipantRepository showEventParticipantRepository = new ShowEventParticipantRepository();

        showEventParticipantRepository.add(showEventParticipant);

        assertEquals(1, showEventParticipantRepository.getAllShowEventParticipants().size());

        String key = "2010-05-01_HALTERSHOW_Deelnemer 1";

        showEventParticipantRepository.delete(key);

        assertEquals(1, showEventParticipantRepository.getAllShowEventParticipants().size());
        assertEquals(null, showEventParticipantRepository.delete(key).toString());
    }

    @Test
    public void getNotKnownShowEvenParticipant() throws IOException {

        exception.expect(NullPointerException.class);

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";

        ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);
        ShowEventParticipantRepository showEventParticipantRepository = new ShowEventParticipantRepository();

        showEventParticipantRepository.add(showEventParticipant);

        assertEquals(1, showEventParticipantRepository.getAllShowEventParticipants().size());

        String key = "2010-05-01_HALTERSHOW_Deelnemer 2";

        showEventParticipantRepository.getShowEventParticipantByKeySet(key).getShowEventKey();

    }

    @Test
    public void getAllShowEventRegistrationsByKeySet() throws IOException {

        ShowEventRepository showEventRepository = new ShowEventRepository();

        String showEventKey1 = "2030-05-01_HALTERSHOW";
        String showEventKey2 = "2030-05-01_FLEECESHOW";
        String participantKey = "Deelnemer 1";

        ShowEventParticipant showEventParticipant1 = new ShowEventParticipant(showEventKey1, participantKey);
        ShowEventParticipant showEventParticipant2 = new ShowEventParticipant(showEventKey2, participantKey);
        ShowEventParticipantRepository showEventParticipantRepository = new ShowEventParticipantRepository();

        showEventParticipantRepository.add(showEventParticipant1);
        showEventParticipantRepository.add(showEventParticipant2);

        assertEquals(2, showEventParticipantRepository.getAllShowEventParticipantsByKeySet().size());
        assertTrue(showEventParticipantRepository.getAllShowEventParticipantsByKeySet().contains("2030-05-01_HALTERSHOW_Deelnemer 1"));
        assertTrue(showEventParticipantRepository.getAllShowEventParticipantsByKeySet().contains("2030-05-01_FLEECESHOW_Deelnemer 1"));

    }
}



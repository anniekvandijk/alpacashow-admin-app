package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipant;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ShowEventParticipantTest {

    private String showEventKey;
    private String participantKey;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newShowEventParticipant() {

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";

        ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);

        assertEquals(showEventKey, showEventParticipant.getShowEventKey());
        assertEquals(participantKey, showEventParticipant.getParticipantKey());
    }

    @Test
    public void showEventKeyNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEventKey can not be empty");

        showEventKey = null;
        participantKey = "Deelnemer 1";

        ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);
    }

    @Test
    public void showEventKeyNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEventKey can not be empty");

        showEventKey = "";
        participantKey = "Deelnemer 1";

        ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);
    }

    @Test
    public void participantKeyNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ParticipantKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = null;ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);
    }

    @Test
    public void participantKeyNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ParticipantKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "";

        ShowEventParticipant showEventParticipant = new ShowEventParticipant(showEventKey, participantKey);
    }
}

package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ShowEventParticipantAnimalTest {

    private String showEventId;
    private String participantId;
    private String animalId;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newShowEventParticipant() {

        showEventId = "cbf38ab5-6fbf-4aa0-8f7d-04ffc2ec7ef7";
        participantId = "498ab86f-4ed9-4140-865c-9a89a62f8136";

        ShowEventParticipantAnimal showEventParticipantAnimal = new ShowEventParticipantAnimal(showEventId, participantId);

        assertEquals(showEventId, showEventParticipantAnimal.getShowEventId());
        assertEquals(participantId, showEventParticipantAnimal.getParticipantId());
    }

    @Test
    public void newShowEventParticipantWithAnimal() {

        showEventId = "cbf38ab5-6fbf-4aa0-8f7d-04ffc2ec7ef7";
        participantId = "498ab86f-4ed9-4140-865c-9a89a62f8136";
        animalId = "06eae947-9a9c-4449-82a2-26fea24952db";

        ShowEventParticipantAnimal showEventParticipantAnimal = new ShowEventParticipantAnimal(showEventId, participantId, animalId);

        assertEquals(showEventId, showEventParticipantAnimal.getShowEventId());
        assertEquals(participantId, showEventParticipantAnimal.getParticipantId());
        assertEquals(animalId, showEventParticipantAnimal.getAnimalId());
    }

    @Test
    public void newShowEventParticipantAddAnimal() {

        showEventId = "cbf38ab5-6fbf-4aa0-8f7d-04ffc2ec7ef7";
        participantId = "498ab86f-4ed9-4140-865c-9a89a62f8136";
        animalId = "06eae947-9a9c-4449-82a2-26fea24952db";

        ShowEventParticipantAnimal showEventParticipantAnimal = new ShowEventParticipantAnimal(showEventId, participantId);

        showEventParticipantAnimal.setAnimalId(animalId);

        assertEquals(showEventId, showEventParticipantAnimal.getShowEventId());
        assertEquals(participantId, showEventParticipantAnimal.getParticipantId());
        assertEquals(animalId, showEventParticipantAnimal.getAnimalId());
    }



    @Test
    public void showEventIdNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEventId can not be empty");

        showEventId = null;
        participantId = "498ab86f-4ed9-4140-865c-9a89a62f8136";

        ShowEventParticipantAnimal showEventParticipantAnimal = new ShowEventParticipantAnimal(showEventId, participantId);
    }

    @Test
    public void showEventIdNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEventId can not be empty");

        showEventId = "  ";
        participantId = "498ab86f-4ed9-4140-865c-9a89a62f8136";

        ShowEventParticipantAnimal showEventParticipantAnimal = new ShowEventParticipantAnimal(showEventId, participantId);
    }

    @Test
    public void participantIdNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ParticipantId can not be empty");

        showEventId = "cbf38ab5-6fbf-4aa0-8f7d-04ffc2ec7ef7";
        participantId = null;

        ShowEventParticipantAnimal showEventParticipantAnimal = new ShowEventParticipantAnimal(showEventId, participantId);
    }

    @Test
    public void participantIdNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ParticipantId can not be empty");

        showEventId = "cbf38ab5-6fbf-4aa0-8f7d-04ffc2ec7ef7";
        participantId = "";

        ShowEventParticipantAnimal showEventParticipantAnimal = new ShowEventParticipantAnimal(showEventId, participantId);
    }
}

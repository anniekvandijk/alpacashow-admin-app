package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.IOException;
import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

public class ParticipantControllerTest {

    private ParticipantRepository participantRepository;

    @Test
    public void getAllParticipants() throws IOException {

        ParticipantController controller = new ParticipantController();

        String result = (String)controller.getParticipants().getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_allparticipants.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void getParticipantByKey() throws IOException {

        ParticipantController controller = new ParticipantController();

        Response resultCode = controller.getParticipantByKey("Deelnemer 2");
        String result = (String) controller.getParticipantByKey("Deelnemer 2").getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_participantbykey.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
        assertEquals(200, resultCode.getStatus());
    }

    @Test
    public void addDeleteUpdateParticipant() throws IOException {

        loadRepository();
        assertEquals(3, participantRepository.getAllParticipants().size());

        ParticipantController controller = new ParticipantController();

        String file = readJsonfile("add_participant.json");
        controller.addParticipant(file);

        loadRepository();
        assertEquals(4, participantRepository.getAllParticipants().size());

        Participant participant = participantRepository.getParticipantByKeySet("Deelnemer 3");
        assertEquals("Grun", participant.getCity());

        String file2 = readJsonfile("update_participant.json");
        controller.updateParticipant("Deelnemer 3", file2);

        loadRepository();
        Participant participant12 = participantRepository.getParticipantByKeySet("Deelnemer 3");
        assertEquals("Groningen", participant12.getCity());

        controller.deleteParticipant("Deelnemer 3");

    }

    @Test
    public void getParticipantByNotExistingKey() throws IOException {

        ParticipantController controller = new ParticipantController();

        Response resultCode = controller.getParticipantByKey("Deelnemer 4");
        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void addParticipantWithWrongData() throws IOException {

        loadRepository();

        ParticipantController controller = new ParticipantController();

        String file = readJsonfile("add_participantWrong.json");
        Response resultCode = controller.addParticipant(file);

        assertEquals(400, resultCode.getStatus());

    }

    @Test
    public void updateParticipantWithWrongKey() throws IOException {

        loadRepository();
        ParticipantController controller = new ParticipantController();

        String file = readJsonfile("update_participant.json");
        Response resultCode = controller.updateParticipant("Deelnemer X", file);

        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void updateParticipantWithWrongData() throws IOException {

        loadRepository();
        ParticipantController controller = new ParticipantController();

        String file = readJsonfile("update_participantWrong.json");
        Response resultCode = controller.updateParticipant("Deelnemer 2", file);

        assertEquals(400, resultCode.getStatus());
    }

    @Test
    public void deleteParticipantWithWrongKey() throws IOException {

        loadRepository();

        ParticipantController controller = new ParticipantController();
        Response resultCode = controller.deleteParticipant("Deelnemer X");

        assertEquals(404, resultCode.getStatus());

    }

    private void loadRepository() throws IOException {

        participantRepository = ApplicationRepositoryService.loadParticipantRepository();
    }
}

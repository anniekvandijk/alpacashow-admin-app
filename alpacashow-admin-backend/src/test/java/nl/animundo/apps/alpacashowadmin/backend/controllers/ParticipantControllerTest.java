package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.IThelper;
import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.IOException;
import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

public class ParticipantControllerTest {

    private RepositoryContext context;
    private ApplicationRepositoryService service;
    private ParticipantController controller;
    private IThelper helper = new IThelper(context, service);

    public ParticipantControllerTest(RepositoryContext context)
    {
        this.context = context;
        controller = new ParticipantController(context);
        service  = new ApplicationRepositoryService();
    }

    @Before
    public void AddShowEvents () throws IOException {
        helper.AddCompleteShowEvent();
    }

    @Test
    public void getAllParticipants() throws IOException {

        String result = (String)controller.getParticipants().getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_allparticipants.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void getParticipantByKey() throws IOException {

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
        assertEquals(5, context.participantRepository.getAllParticipants().size());

        String file = readJsonfile("add_participant.json");
        controller.addParticipant(file);

        loadRepository();
        assertEquals(6, context.participantRepository.getAllParticipants().size());

        Participant participant = context.participantRepository.getParticipantById("Deelnemer 3");
        assertEquals("Grun", participant.getCity());

        String file2 = readJsonfile("update_participant.json");
        controller.updateParticipant("Deelnemer 3", file2);

        loadRepository();
        Participant participant12 = context.participantRepository.getParticipantById("Deelnemer 3");
        assertEquals("Groningen", participant12.getCity());

        controller.deleteParticipant("Deelnemer 3");

    }

    @Test
    public void getParticipantByNotExistingKey() throws IOException {

        Response resultCode = controller.getParticipantByKey("Deelnemer 4");
        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void addParticipantWithWrongData() throws IOException {

        loadRepository();

        String file = readJsonfile("add_participantWrong.json");
        Response resultCode = controller.addParticipant(file);

        assertEquals(400, resultCode.getStatus());

    }

    @Test
    public void updateParticipantWithWrongKey() throws IOException {

        loadRepository();
        String file = readJsonfile("update_participant.json");
        Response resultCode = controller.updateParticipant("Deelnemer X", file);

        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void updateParticipantWithWrongData() throws IOException {

        loadRepository();

        String file = readJsonfile("update_participantWrong.json");
        Response resultCode = controller.updateParticipant("Deelnemer 2", file);

        assertEquals(400, resultCode.getStatus());
    }

    @Test
    public void deleteParticipantWithWrongKey() throws IOException {

        loadRepository();

        Response resultCode = controller.deleteParticipant("Deelnemer X");

        assertEquals(404, resultCode.getStatus());

    }

    private void loadRepository() throws IOException {

        context.participantRepository = service.loadParticipantRepository();
    }
}

package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

public class ParticipantControllerTest {

    private ParticipantController controller;
    private ObjectMapper mapper;

    @Before
    public void before() throws IOException {
        controller = new ParticipantController();
        mapper = new ObjectMapper();
    }

    @Test
    public void getAllParticipants() throws IOException {

        Response response = controller.getParticipants();
        assertEquals(200, response.getStatus());

        List<Participant> list = mapper.readValue(response.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, Participant.class));
        assertEquals(5, list.size());
    }

    @Test
    public void getParticipantById() throws IOException {

        Response response = controller.getParticipantById("e8919da0-92bc-426b-a125-ed0311fbe2eb");
        assertEquals(200, response.getStatus());

        Participant participant = mapper.readValue(response.getEntity().toString(), Participant.class);
        assertEquals("e8919da0-92bc-426b-a125-ed0311fbe2eb", participant.getId());
    }

    @Test
    public void addDeleteParticipant() throws IOException {

        String file = readJsonfile("add_participant.json");
        Response response1 = controller.addParticipant(file);
        assertEquals(200, response1.getStatus());

        Response response2 = controller.getParticipants();
        List<Participant> list = mapper.readValue(response2.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, Participant.class));
        assertEquals(6, list.size());

        String participantId = null;
        for (Participant participant: list)
        {

            if (participant.getName().equals("Deelnemer 3"))
            {
                participantId = participant.getId();
            }
        }

        Response response3 = controller.deleteParticipant(participantId);
        assertEquals(200, response3.getStatus());
        Response response4 = controller.getParticipants();
        List<Participant> list2 = mapper.readValue(response4.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, Participant.class));
        assertEquals(5, list2.size());

    }

    @Test
    public void updateParticipant() throws IOException {
        String file = readJsonfile("update_participant.json");
        Response response = controller.updateParticipant("ed272dd0-a59d-4674-ac07-343e3fb9a61b", file);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void getParticipantByNotExistingKey() throws IOException {

        Response response = controller.getParticipantById("Some not known");
        assertEquals(404, response.getStatus());
    }

    @Test
    public void addParticipantWithWrongData() throws IOException {

        String file = readJsonfile("add_participantWrong.json");
        Response response = controller.addParticipant(file);

        assertEquals(400, response.getStatus());

    }

    @Test
    public void updateParticipantWithWrongKey() throws IOException {

        String file = readJsonfile("update_participant.json");
        Response response = controller.updateParticipant("not known chip", file);

        assertEquals(404, response.getStatus());
    }

    @Test
    public void updateParticipantWithWrongData() throws IOException {

        String file = readJsonfile("update_participantWrong.json");
        Response response = controller.updateParticipant("1d1bb925-ed76-432a-bd07-554040000a31", file);

        assertEquals(400, response.getStatus());
    }

    @Test
    public void deleteParticipantWithWrongKey() throws IOException {

        Response response = controller.deleteParticipant("Participant X");

        assertEquals(404, response.getStatus());

    }
}

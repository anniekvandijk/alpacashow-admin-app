package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;
import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

public class ShowEventControllerTest {

    private ShowEventController controller;
    private ObjectMapper mapper;

    @Before
    public void before() throws IOException {
        controller = new ShowEventController();
        mapper = new ObjectMapper();
    }

    @Test
    public void getAllShowEvents() throws IOException {

        Response response = controller.getShowEvents();
        assertEquals(200, response.getStatus());

        List<ShowEvent> list = mapper.readValue(response.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, ShowEvent.class));
        assertEquals(4, list.size());
    }

    @Test
    public void getShowEventById() throws IOException {

        Response response = controller.getShowEventById("5a3f5b84-cb3f-4ebc-b73a-9d411cb4109b");
        assertEquals(200, response.getStatus());

        ShowEvent participant = mapper.readValue(response.getEntity().toString(), ShowEvent.class);
        assertEquals("5a3f5b84-cb3f-4ebc-b73a-9d411cb4109b", participant.getId());
    }

    @Test
    public void addDeleteShowEvent() throws IOException {

        String file = readJsonfile("add_showevent.json");
        Response response1 = controller.addShowEvent(file);
        assertEquals(200, response1.getStatus());

        Response response2 = controller.getShowEvents();
        List<ShowEvent> list = mapper.readValue(response2.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, ShowEvent.class));
        assertEquals(5, list.size());

        String showEventId = null;
        for (ShowEvent showEvent: list)
        {

            if (showEvent.getName().equals("Test 2017"))
            {
                showEventId = showEvent.getId();
            }
        }

        Response response3 = controller.deleteShowEvent(showEventId);
        assertEquals(200, response3.getStatus());
        Response response4 = controller.getShowEvents();
        List<ShowEvent> list2 = mapper.readValue(response4.getEntity().toString(),
                TypeFactory.defaultInstance().constructCollectionType(List.class, ShowEvent.class));
        assertEquals(4, list2.size());

    }

    @Test
    public void updateShowEvent() throws IOException {
        String file = readJsonfile("update_showevent.json");
        Response response = controller.updateShowEvent("5a3f5b84-cb3f-4ebc-b73a-9d411cb4109b", file);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void getShowEventByNotExistingKey() throws IOException {

        Response response = controller.getShowEventById("Some not known");
        assertEquals(404, response.getStatus());
    }

    @Test
    public void addShowEventWithWrongData() throws IOException {

        String file = readJsonfile("add_showeventWrong.json");
        Response response = controller.addShowEvent(file);

        assertEquals(400, response.getStatus());

    }

    @Test
    public void updateShowEventWithWrongKey() throws IOException {

        String file = readJsonfile("update_showevent.json");
        Response response = controller.updateShowEvent("not known chip", file);

        assertEquals(404, response.getStatus());
    }

    @Test
    public void updateShowEventWithWrongData() throws IOException {

        String file = readJsonfile("update_showeventWrong.json");
        Response response = controller.updateShowEvent("cbef0073-5bc3-493e-99da-0e9ef967b3d9", file);

        assertEquals(400, response.getStatus());
    }

    @Test
    public void deleteShowEventWithWrongKey() throws IOException {

        Response response = controller.deleteShowEvent("ShowEvent X");

        assertEquals(404, response.getStatus());

    }
}

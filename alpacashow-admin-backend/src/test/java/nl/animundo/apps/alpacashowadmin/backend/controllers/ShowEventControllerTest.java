package nl.animundo.apps.alpacashowadmin.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Anniek van Dijk on 6-8-2016.
 *
 * This class simulates the webservice. It's not a direct webservice test.
 * When a test fales in this class, take a look at the ShowEventController.class too
 */


public class ShowEventControllerTest {
    private static Logger logger = LoggerFactory.getLogger(ShowEventControllerTest.class);

    // TODO Make environment configurable
    private String environment = "dev";
    final String workingDir = System.getProperty("user.dir");
    private ShowEventRepository showEventRepo;

    @Test
    public void getAllShowEvents() throws IOException {

        ShowEventController controller = new ShowEventController();

        String result = controller.getShowEvents();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_allshowevents.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void getShowEventByKey() throws IOException {

        ShowEventController controller = new ShowEventController();

        String result = controller.getShowEventByKey("5027dbc9-e4af-46ef-b5ca-5338ba8ebbbc");
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_showeventbykey.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void addAndDeleteShowEvent() throws IOException {

        ShowEventController controller = new ShowEventController();

        // TODO nullpointerexception
//        String showEvent = readJsonfile("add_showevent.json");
//        controller.addShowEvent(showEvent);
//        ShowEvent getEvent = showEventRepo.getShowEventsByName("Test 2017");
//        assertEquals("Test 2017", getEvent.getName());
//
//        showEventRepo.delete(getEvent.getID());
//        assertEquals(2, showEventRepo.size());
//        saveRepository();
    }

    @Test
    public void updateShowEvent() throws IOException {

        // TODO howto update?

        ShowEventController controller = new ShowEventController();

//        controller.updateShowEvent("5027dbc9-e4af-46ef-b5ca-5338ba8ebbbc");
//
//        loadRepository();
//        showEventRepo.delete("5027dbc9-e4af-46ef-b5ca-5338ba8ebbbc");
//        assertEquals(1, showEventRepo.size());
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Update 1
//        String showEvent = readJsonfile("update_showevent.json");
//        ShowEvent event = mapper.readValue(showEvent, ShowEvent.class);
//        showEventRepo.add(event);
//        assertEquals(2, showEventRepo.size());
//        saveRepository();
//
//        loadRepository();
//        ShowEvent getEvent = showEventRepo.getShowEventsByKeySet("Breda 2017_2017-04-01");
//        assertEquals("Breda update", getEvent.getLocation());
//        assertEquals("FLEECESHOW", getEvent.toStringShow());
//
//        // Update back to old situation
//        showEventRepo.delete("Breda 2017_2017-04-01");
//        String showEvent2 = readJsonfile("get_showeventbykey.json");
//        ShowEvent event2 = mapper.readValue(showEvent2, ShowEvent.class);
//        showEventRepo.add(event2);
//        assertEquals(2, showEventRepo.size());
//        saveRepository();
//
//        loadRepository();
//        ShowEvent getEvent3 = showEventRepo.getShowEventsByKeySet("Breda 2017_2017-04-01");
//        assertEquals("Breda", getEvent3.getLocation());
//        assertEquals("HALTERSHOW, MALE_PROGENY_SHOW", getEvent3.toStringShow());

    }

    private String readJsonfile(String fileName) throws IOException {
        File file = new File(workingDir, "src/test/resources/json/" + fileName);
        assertTrue(file.isFile() && file.exists() && file.canRead());
        BufferedReader reader = new BufferedReader (new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String result = "";
        String line = reader.readLine();
        while (line != null) {
            builder.append(line);
            line = reader.readLine();
        }
        return builder.toString();
    }
}

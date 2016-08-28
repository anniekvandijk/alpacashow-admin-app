package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowEventControllerTest {

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

        String result = controller.getShowEventByKey("Breda 2017_2017-04-01");
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_showeventbykey.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void addAndDeleteShowEvent() throws IOException {

        loadRepository();
        assertEquals(2, showEventRepo.size());

        ShowEventController controller = new ShowEventController();

        String showEvent = readJsonfile("add_showevent.json");
        controller.addShowEvent(showEvent);

        loadRepository();
        assertEquals(3, showEventRepo.size());

        ShowEvent event = showEventRepo.search("Test 2017_2017-03-01");
        assertEquals("Test 2017", event.getName());

        controller.deleteShowEvent("Test 2017_2017-03-01");

        loadRepository();
        assertEquals(2, showEventRepo.size());

    }

    @Test
    public void updateShowEvent() throws IOException {

        ShowEventController controller = new ShowEventController();

        String showEvent = readJsonfile("update_showevent.json");
        controller.updateShowEvent("Breda 2017_2017-04-01", showEvent);

        loadRepository();
        ShowEvent getEvent = showEventRepo.getShowEventsByKeySet("Breda 2017_2017-04-01");
        assertEquals("Breda update", getEvent.getLocation());
        assertEquals("FLEECESHOW", getEvent.toStringShow());

        String showEvent2 = readJsonfile("get_showeventbykey.json");
        controller.updateShowEvent("Breda 2017_2017-04-01", showEvent2);

        loadRepository();
        ShowEvent getEvent3 = showEventRepo.getShowEventsByKeySet("Breda 2017_2017-04-01");
        assertEquals("Breda", getEvent3.getLocation());
        assertEquals("HALTERSHOW, MALE_PROGENY_SHOW", getEvent3.toStringShow());

    }

    private void loadRepository() throws IOException {

        showEventRepo = ApplicationRepositoryService.loadShowEventRepository();
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

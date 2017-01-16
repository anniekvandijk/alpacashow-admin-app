package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.*;

import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowEventControllerTest {

    private ShowEventRepository showEventRepo;
    private ApplicationRepositoryService service = new ApplicationRepositoryService();

    @Test
    public void getAllShowEvents() throws IOException {

        ShowEventController controller = new ShowEventController(showEventRepo);

        String result = (String)controller.getShowEvents().getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_allshowevents.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void getShowEventByKey() throws IOException {

        ShowEventController controller = new ShowEventController(showEventRepo);

        Response resultCode = controller.getShowEventByKey("2017-04-01_MALE_PROGENY_SHOW");
        String result = (String) controller.getShowEventByKey("2017-04-01_MALE_PROGENY_SHOW").getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_showeventbykey.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
        assertEquals(200, resultCode.getStatus());
    }

    @Test
    public void addDeleteUpdateShowEvent() throws IOException {

        loadRepository();
        assertEquals(2, showEventRepo.getAllShowEvents().size());

        ShowEventController controller = new ShowEventController(showEventRepo);

        String showEvent = readJsonfile("add_showevent.json");
        controller.addShowEvent(showEvent);

        loadRepository();
        assertEquals(3, showEventRepo.getAllShowEvents().size());

        ShowEvent event = showEventRepo.getShowEventByKeySet("2017-03-01_HALTERSHOW");
        assertEquals("Test 2017", event.getName());

        String showEvent2 = readJsonfile("update_showevent.json");
        controller.updateShowEvent("2017-03-01_HALTERSHOW", showEvent2);

        loadRepository();
        ShowEvent getEvent3 = showEventRepo.getShowEventByKeySet("2017-03-01_HALTERSHOW");
        assertEquals("Test update", getEvent3.getLocation());

        controller.deleteShowEvent("2017-03-01_HALTERSHOW");

    }

    @Test
    public void getShowEventByNotExistingKey() throws IOException {

        ShowEventController controller = new ShowEventController(showEventRepo);

        Response resultCode = controller.getShowEventByKey("2017-04-01_HALTERSHOW");
        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void addShowEventWithWrongData() throws IOException {

        loadRepository();

        ShowEventController controller = new ShowEventController(showEventRepo);

        String showEvent = readJsonfile("add_showeventWrong.json");
        Response resultCode = controller.addShowEvent(showEvent);

        assertEquals(400, resultCode.getStatus());

    }

    @Test
    public void updateShowEventWithWrongKey() throws IOException {

        loadRepository();
        ShowEventController controller = new ShowEventController(showEventRepo);

        String showEvent = readJsonfile("update_showevent.json");
        Response resultCode = controller.updateShowEvent("Breda 2017_2018-04-01", showEvent);

        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void updateShowEventWithWrongData() throws IOException {

        loadRepository();
        ShowEventController controller = new ShowEventController(showEventRepo);

        String showEvent = readJsonfile("update_showeventWrong.json");
        Response resultCode = controller.updateShowEvent("2017-04-01_MALE_PROGENY_SHOW", showEvent);

        assertEquals(400, resultCode.getStatus());
    }

    @Test
    public void deleteShowEventWithWrongKey() throws IOException {

        loadRepository();

        ShowEventController controller = new ShowEventController(showEventRepo);
        Response resultCode = controller.deleteShowEvent("2017-03-01_HALTERSHO");

        assertEquals(404, resultCode.getStatus());

    }

    private void loadRepository() throws IOException {

        showEventRepo = service.loadShowEventRepository();
    }
}
